class MyHashSet {
    public List<Integer>[] buckets;
    public int size = 10000;

    public MyHashSet() {
        this.buckets = new ArrayList[size];
        for( int i = 0; i < size; i++ ){
            buckets[i] = new ArrayList<>();
        }
    }
    public int createHashKey(int key) {
        return key % size;
    }
    public void add(int key) {
        int index = createHashKey(key);
        if(!buckets[index].contains(key)) buckets[index].add(key);
    }
    
    public void remove(int key) {
        int index = createHashKey(key);
        buckets[index].remove((Integer) key);
    }
    
    public boolean contains(int key) {
        int index = createHashKey(key);
        return buckets[index].contains(key) ;       
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */