class MyHashMap {
    private class Entry {
        public int key;
        public int value;
        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
            ;
        }
    }

    private List<Entry>[] map;
    private int size = 10000;

    public MyHashMap() {
        map = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            map[i] = new ArrayList<>();
        }
    }

    public int createHashKey(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int index = createHashKey(key);
        for (Entry e : map[index]) {
            if (e.key == key)
                e.value = value;
        }
        map[index].add(new Entry(key, value));
    }

    public int get(int key) {
        int index = createHashKey(key);
        for (Entry e : map[index]) {
            if (e.key == key)
               return e.value;
        } return -1;
    }

    public void remove(int key) {
        int index = createHashKey(key);
        map[index].removeIf(e -> e.key == key);
    }
}