import java.util.HashMap;
import java.util.Map;
// 使用双向链表保存数据
// 使用HashMap保存key对应的node，用来查询有没有一个key
// 链表中删除节点后同时要从map中删除，插入节点后要插入map
class LRUCache {
    class LinkedNode {
        private int key;
        private int value;
        private LinkedNode pre;
        private LinkedNode next;
        LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
        LinkedNode() {}
    }

    private int size;
    private int capacity;
    private Map<Integer, LinkedNode> map;
    private LinkedNode head;
    private LinkedNode tail;

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        head = new LinkedNode();
        tail = new LinkedNode();
        head.pre = null;
        tail.next = null;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        LinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);  // 访问过放到最前面
        return node.value;
    }

    public void put(int key, int value) {
        LinkedNode node = map.get(key);
        if (node == null) {
            if (size == capacity) {
                LinkedNode t = removeTail();
                map.remove(t.key);  // 更新map
                --size;
            }
            node = new LinkedNode(key, value);
            addToHead(node);
            map.put(key, node);   // 更新map
            ++size;
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
    private void moveToHead(LinkedNode node) {
        // 移动前的两个指针
        node.pre.next = node.next;
        node.next.pre = node.pre;
        // 移动后的两个指针
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }
    private LinkedNode removeTail() {
        LinkedNode node = tail.pre;
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return node;
    }
    private void addToHead(LinkedNode node) {
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }
}
