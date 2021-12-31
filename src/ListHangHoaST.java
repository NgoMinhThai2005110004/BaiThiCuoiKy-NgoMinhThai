import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ListHangHoaST {
    private Node head, tail;
    HangHoaST hangHoa = new HangHoaST();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date ngayNhap = new Date();
    Scanner sc = new Scanner(System.in);
    public ListHangHoaST()
    {
        hangHoa.autoId = 1;
        this.head = null;
        this.tail = null;
    }
    public boolean isEmpty()
    {
        return this.head == null;
    }
    public void ThemHangHoa(HangHoaST hangHoa)
    {
        if(isEmpty())
        {
            this.head = this.tail = new Node(hangHoa);
            return;
        }
        Node newNode = new Node(hangHoa);
        this.tail.setNext(newNode);
        this.tail = newNode;

    }
    public void HienThiHangHoa()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~THONG TIN HANG HOA~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("%-20S %-20S %-20S %-20S %-20S %-20S\n", "ma hang", "ten hang", "so luong", "gia hang", "loai hang", "ngay nhap kho");
        Node node = this.head;
        while(node != null){
            System.out.printf("%-20d %-20S %-15d %-7.3fVND %20S %20S\n", node.getHangHoa().iD, node.getHangHoa().tenHangHoa, node.getHangHoa().soLuong, node.getHangHoa().giaHang, node.getHangHoa().getLoai(),df.format(node.getHangHoa().ngayNhap)); 
            node = node.getNext();
        }
    }
    public void ThemNhieuHangHoa(HangHoaST...hangHoas)
    {
        for(HangHoaST hangHoa : hangHoas)
        {
            ThemHangHoa(hangHoa);
        }
    }
    public boolean XoaHangHoa(int id)
    {
        Node node = this.head;
        if(this.head.getHangHoa().getiD() == id){
            this.head = this.head.getNext();
            System.out.println("Da Xoa Doi Tuong Thanh Cong");
            return true;
        }
        while(node != null)
        {
            if(node.getNext().getHangHoa().getiD() == id){
                node.setNext(node.getNext().getNext());
                System.out.println("Xoa Thanh Cong");
                return true;
            }
            else{
                System.out.println("ID Khong Ton Tai");
            }
            node = node.getNext();
        }
        System.out.println("Xoa Doi Tuong Khong Thanh Cong!");
        return false;
    }
    public boolean SuaThongTin(int id){
        Node node = this.head;
        while(node != null)
        {
            if(node.getHangHoa().getiD() == id)
            {
                String loaiHh = null;
                System.out.println("Nhap Ten Hang:");
                String ten = sc.nextLine();
                System.out.println("Nhap So Luong:");
                int soLuong = sc.nextInt();
                System.out.println("Nhap Gia:");
                float gia = sc.nextFloat();
                System.out.println("Nhap Loai Hang [1: Thuc Pham; 2: Sanh Su; 3: Dien May]");
                int l = sc.nextInt();
                switch(l)
                {
                    case 1: loaiHh = "Thuc Pham";
                    break;
                    case 2: loaiHh = "Sanh Su";
                    break;
                    case 3: loaiHh = "Dien May";
                    break;
                    default: System.out.println("Loai Khong Hop Le!!!");
                    break;
                }
                sc.nextLine();
                try {
                    System.out.println("Nhap Ngay Vao Kho [dd/MM/yyyy]");
                    ngayNhap = df.parse(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Ngay Khong Hop Le!!!!");
                }
                node.getHangHoa().setTenHangHoa(ten);
                node.getHangHoa().setSoLuong(soLuong);
                node.getHangHoa().setGiaHang(gia);
                node.getHangHoa().setLoai(loaiHh);
                node.getHangHoa().setNgayNhap(ngayNhap);
                return true;
            }
            node = node.getNext();
        }
        System.out.println("Khong The Sua!!!");
        return false;
    }
    public void SapXepTangDan(){
        Node node = this.head, node2 = null;
        HangHoaST tempHangHoa;
        if(head == null)
        return;
        else{
            while(node != null){
                node2 = node.next;
                while(node2 != null){
                    if(node.hangHoa.giaHang > node2.hangHoa.giaHang){
                        tempHangHoa = node.hangHoa;
                        node.hangHoa = node2.hangHoa;
                        node2.hangHoa = tempHangHoa;
                    }
                    node2 = node2.next;
                }
                node = node.next;
            }
        }
        HienThiHangHoa();
    }

    public void SapXepGiamDan(){
        Node node = this.head, node2 = null;
        HangHoaST tempHangHoa;
        if(head == null)
        return;
        else{
            while(node != null){
                node2 = node.next;
                while(node2 != null){
                    if(node.hangHoa.giaHang < node2.hangHoa.giaHang){
                        tempHangHoa = node.hangHoa;
                        node.hangHoa = node2.hangHoa;
                        node2.hangHoa = tempHangHoa;
                    }
                    node2 = node2.next;
                }
                node = node.next;
            }
        }
        HienThiHangHoa();
    }
    public boolean TimKiemTheoLoai(String l){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~THONG TIN HANG HOA~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("%-20S %-20S %-20S %-20S %-20S %-20S\n", "ma hang", "ten hang", "so luong", "gia hang", "loai hang", "ngay nhap kho");
        boolean isFound = false;
        Node node = this.head;
        while(node != null)
        {
            if(node.getHangHoa().getLoai().contains(l))
            {
                System.out.printf("%-20d %-20S %-15d %-7.3fVND %20S %20S\n", node.getHangHoa().iD, node.getHangHoa().tenHangHoa, node.getHangHoa().soLuong, node.getHangHoa().giaHang, node.getHangHoa().getLoai(),df.format(node.getHangHoa().ngayNhap)); 
                isFound = true;
            }
            node = node.getNext();
        }
        if(!isFound)
        {
            System.out.println("Loai Muon Tim Khong Hop Le!");
            return false;
        }
        return true;
    }
    public boolean TimKiemTheoGia(float gF, float gT){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~THONG TIN HANG HOA~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("%-20S %-20S %-20S %-20S %-20S %-20S\n", "ma hang", "ten hang", "so luong", "gia hang", "loai hang", "ngay nhap kho");
        boolean isFound = false;
        Node node = this.head;
        while(node != null)
        {
            if(node.getHangHoa().getGiaHang() >= gF && node.getHangHoa().getGiaHang() <= gT)
            {
                System.out.printf("%-20d %-20S %-15d %-7.3fVND %20S %20S\n", node.getHangHoa().iD, node.getHangHoa().tenHangHoa, node.getHangHoa().soLuong, node.getHangHoa().giaHang, node.getHangHoa().getLoai(),df.format(node.getHangHoa().ngayNhap)); 
                isFound = true;
            }
            node = node.getNext();
        }
        if(!isFound)
        {
            System.out.println("Gia Muon Tim Khong Hop Le!");
            return false;
        }
        return true;
    }
    public void ThongKe(){
        Node node = this.head;
        int sLtemp = 0;
        float gTtemp = 0;
        while(node != null){
            sLtemp += node.getHangHoa().getSoLuong();
            gTtemp += node.getHangHoa().getGiaHang();
            node = node.getNext();
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~BANG THONG KE~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("%-30S %-30S\n", "Tong so luong", "Tong gia tri");
        System.out.printf("%-30d %-12.3fVND\n", sLtemp, gTtemp);
    }
    public void DuLieuMacDinh(){
        try {
            String sDate1 = "20/12/2021";  
            String sDate2 = "12/12/2021";  
            String sDate3 = "10/12/2021";  
            String sDate4 = "19/12/2021";  
            String sDate5 = "21/12/2021";  
            String sDate6 = "01/12/2021";  
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");  
            Date date1=formatter1.parse(sDate1);  
            Date date2=formatter1.parse(sDate2);  
            Date date3=formatter1.parse(sDate3);  
            Date date4=formatter1.parse(sDate4);  
            Date date5=formatter1.parse(sDate5);  
            Date date6=formatter1.parse(sDate6); 
            HangHoaST HangHoaST1 = new HangHoaST(200, "Chuoi cau", "Thuc Pham", 100, date3);
            HangHoaST HangHoaST2 = new HangHoaST(1400, "Sau rieng", "Thuc Pham", 300, date2);
            HangHoaST HangHoaST3 = new HangHoaST(5000, "Chen su", "Sanh Su", 400, date4);
            HangHoaST HangHoaST4 = new HangHoaST(20000, "To su", "Sanh Su", 200, date5);
            HangHoaST HangHoaST5 = new HangHoaST(5000, "May giat", "Dien May", 100, date1);
            HangHoaST HangHoaST6 = new HangHoaST(600, "Rau cau", "Thuc Pham", 90, date4);
            HangHoaST HangHoaST7 = new HangHoaST(800, "Muong su", "Sanh Su", 10, date2);
            HangHoaST HangHoaST8 = new HangHoaST(900, "Chuoi gia", "Thuc Pham", 600, date5);
            HangHoaST HangHoaST9 = new HangHoaST(2000, "Laptop", "Dien May", 1500, date4);
            HangHoaST HangHoaST10 = new HangHoaST(3000, "Xoai", "Thuc Pham", 600, date2);
            HangHoaST HangHoaST11 = new HangHoaST(4000, "May tinh", "Dien May", 90, date4);
            HangHoaST HangHoaST12 = new HangHoaST(8000, "Xuc xich", "Thuc Pham", 80, date2);
            HangHoaST HangHoaST13 = new HangHoaST(1000, "Ly su", "Sanh Su", 30, date5);
            HangHoaST HangHoaST14 = new HangHoaST(7000, "Thit nguoi", "Thuc Pham", 50, date1);
            HangHoaST HangHoaST15 = new HangHoaST(20, "May nuoc nong", "Dien May", 840, date3);
            HangHoaST HangHoaST16 = new HangHoaST(4000, "Noi com", "Dien May", 94, date2);
            HangHoaST HangHoaST17 = new HangHoaST(300, "Sushi", "Thuc Pham", 895, date3);
            HangHoaST HangHoaST18 = new HangHoaST(70, "Dua hau", "Thuc Pham", 95, date4);
            HangHoaST HangHoaST19 = new HangHoaST(900, "Tao xanh", "Thuc Pham", 800, date5);
            HangHoaST HangHoaST20 = new HangHoaST(80, "Gan ngong", "Thuc Pham", 900, date2);
            ThemHangHoa(HangHoaST1);
            ThemHangHoa(HangHoaST2);
            ThemHangHoa(HangHoaST3);
            ThemHangHoa(HangHoaST4);
            ThemHangHoa(HangHoaST5);
            ThemHangHoa(HangHoaST6);
            ThemHangHoa(HangHoaST7);
            ThemHangHoa(HangHoaST8);
            ThemHangHoa(HangHoaST9);
            ThemHangHoa(HangHoaST10);
            ThemHangHoa(HangHoaST11);
            ThemHangHoa(HangHoaST12);
            ThemHangHoa(HangHoaST13);
            ThemHangHoa(HangHoaST14);
            ThemHangHoa(HangHoaST15);
            ThemHangHoa(HangHoaST16);
            ThemHangHoa(HangHoaST17);
            ThemHangHoa(HangHoaST18);
            ThemHangHoa(HangHoaST19);
            ThemHangHoa(HangHoaST20);
        } catch (Exception e) {
            e.getCause();
        }
    }
}
