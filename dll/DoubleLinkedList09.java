package dll;

public class DoubleLinkedList09 {
    Node09 head;
    Node09 tail;

    public DoubleLinkedList09() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa09 data) {
        Node09 newNode = new Node09(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(Mahasiswa09 data) {
        Node09 newNode = new Node09(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAfter(String keyNim, Mahasiswa09 data) {
        Node09 current = head;

        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }

        Node09 newNode = new Node09(data);

        if(current == tail) {
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        System.out.println("Node berhasil disisipkan setelah NIM " + keyNim);
    }

    public void print() {
        if (!isEmpty()) {
            Node09 current = head;
            while (current != null) {
                current.data.tampil();
                current = current.next;
            }
        } else {
            System.out.println("Linked list masih kosong!");
        }
    }
    
    public Node09 search(String nim) {
        Node09 current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }
        System.out.println("Data berhasil dihapus.");
        System.out.println("Data yang terhapus adalah ...");
        head.data.tampil();
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }
        System.out.println("Data berhasil dihapus.");
        System.out.println("Data yang terhapus adalah ...");
        tail.data.tampil();
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }
    
    public void add(Mahasiswa09 data, int index) {
        if (index < 0) {
            System.out.println("Index tidak valid.");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node09 current = head;
        int i = 0;
        while (current != null && i < index - 1) {
            current = current.next;
            i++;
        }
        if (current == null) {
            System.out.println("Index melebihi jumlah elemen.");
            return;
        }
        Node09 newNode = new Node09(data);
        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }
        current.next = newNode;
        System.out.println("Data berhasil ditambahkan pada index ke-" + index);
    }

    public void removeAfter(String keyNim) {
        Node09 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
        if (current != null && current.next != null) {
            Node09 toDelete = current.next;
            System.out.println("Menghapus data setelah NIM " + keyNim);
            toDelete.data.tampil();
            current.next = toDelete.next;
            if (toDelete.next != null) {
                toDelete.next.prev = current;
            } else {
                tail = current;
            }
        } else {
            System.out.println("Node setelah NIM " + keyNim + " tidak ditemukan atau kosong.");
        }
    }

    public void remove(int index) {
        if (index < 0 || head == null) {
            System.out.println("Index tidak valid atau list kosong.");
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        Node09 current = head;
        int i = 0;
        while (current != null && i < index) {
            current = current.next;
            i++;
        }
        if (current == null) {
            System.out.println("Index melebihi jumlah elemen.");
            return;
        }
        System.out.println("Data yang dihapus pada index ke-" + index + ":");
        current.data.tampil();
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }
    }

    public void getFirst() {
        if (!isEmpty()) {
            System.out.println("Data di HEAD:");
            head.data.tampil();
        } else {
            System.out.println("List kosong.");
        }
    }

    public void getLast() {
        if (!isEmpty()) {
            System.out.println("Data di TAIL:");
            tail.data.tampil();
        } else {
            System.out.println("List kosong.");
        }
    }

    public void getIndex(int index) {
        Node09 current = head;
        int i = 0;
        while (current != null && i < index) {
            current = current.next;
            i++;
        }
        if (current != null) {
            System.out.println("Data pada index ke-" + index + ":");
            current.data.tampil();
        } else {
            System.out.println("Data pada index ke-" + index + " tidak ditemukan.");
        }
    }

    public int size() {
        int count = 0;
        Node09 current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Menu tambahan untuk dipanggil di DLLMain
    public void tampilkanUkuran() {
        System.out.println("Jumlah data dalam list: " + size());
    }
}
