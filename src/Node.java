public class Node {
    public HangHoaST hangHoa;
    public Node next;
    public Node()
    {

    }//saasasa//
    public Node(HangHoaST hangHoa)
    {
        this.hangHoa = hangHoa;
        this.next = null;
    }
    public HangHoaST getHangHoa() {
        return hangHoa;
    }
    public void setHangHoa(HangHoaST hangHoa) {
        this.hangHoa = hangHoa;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node(HangHoaST hangHoa, Node next) {
        this.hangHoa = hangHoa;
        this.next = next;
    }
}
