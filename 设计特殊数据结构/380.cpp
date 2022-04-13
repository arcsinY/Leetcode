// 为了 O(1) 确定是否存在某个元素，需要哈希表。为了 O(1) 获取某个位置元素，需要数组
// 随机数可以获取 [0,arr.size() - 1] 范围内的数据，但获取到的数据可能是已经删除的。需要避免数组中间存在已经删除的数据
// 每次删除时将删除元素与数组末尾元素交换位置，保证每次删除的都是数组末尾元素
class RandomizedSet {
public:
    RandomizedSet() {
        srand((unsigned)time(NULL));
    }
    
    bool insert(int val) {
        if (index.find(val) != index.end()) {
            return false;
        }
        arr.push_back(val);
        index.insert(pair<int,int>(val, arr.size() - 1));
        return true;
    }
    
    bool remove(int val) {
        auto it = index.find(val);
        if (index.find(val) == index.end()) {
            return false;
        }
        index[arr[arr.size() - 1]] = it->second;
        swap(it->second, arr.size() - 1);
        index.erase(val);
        arr.pop_back();
        return true;
    }
    
    int getRandom() {
        int idx = rand() % arr.size();
        return arr[idx];
    }

private:
    vector<int> arr;
    unordered_map<int, int> index;
    void swap(int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
};
