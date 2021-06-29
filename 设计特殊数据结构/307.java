// 线段树计算区间和，支持O(log n)复杂度的元素修改
// 前缀数组的修改复杂度为O(n)
// root为当前节点编号，start和end为当前节点存储的区间的两个端点。所有的操作都需要这三个参数来自顶向下递归寻找
class NumArray {
    int[] nums;
    int[] tree;
    int n;
    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        tree = new int[4 * n];
        buildTree(1, 0, n - 1);
    }

    public void update(int index, int val) {
        updateTree(1,0,n - 1,index, val);
    }

    public int sumRange(int left, int right) {
        return queryTree(1, 0, n - 1, left, right);
    }
  
    public void buildTree(int root, int start, int end) {
        if (start == end) {
            tree[root] = nums[start];
            return;
        }
        int mid = (start + end) / 2;
        buildTree(root * 2, start, mid);
        buildTree(root * 2 + 1, mid + 1, end);
        tree[root] = tree[root * 2] + tree[root * 2 + 1];
    }

    public void updateTree(int root, int start, int end, int index, int val) {
        if (start == end) {
            nums[index] = val;
            tree[root] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (index >= start && index <= mid) {
            updateTree(root * 2, start, mid, index, val);
        } else {
            updateTree(root * 2 + 1, mid + 1, end, index, val);
        }
        tree[root] = tree[root * 2] + tree[root * 2 + 1];
    }

    public int queryTree(int root, int start, int end, int left, int right) {
        // 节点存储的区间与查询区间没有重叠
        if (end < left || start > right) {
            return 0;
        }
        // 节点存储的区间包含在查询区间之中，这部分都会加入到结果中，因此节点的值直接返回
        if (left <= start && right >= end) {
            return tree[root];
        }
        if (start == end) {
            return tree[root];
        }
        int mid = (start + end) / 2;
        // 划分左右两个区间查询
        int leftSum = queryTree(root * 2, start, mid, left, right);
        int rightSum = queryTree(root * 2 + 1, mid + 1, end, left, right);
        return leftSum + rightSum;
    }
}
