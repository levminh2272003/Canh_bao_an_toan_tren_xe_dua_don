# Thiết kế hệ thống cảnh báo an toàn trên xe đưa đón học sinh  

## Giới thiệu  

Đề tài **“Thiết kế hệ thống cảnh báo an toàn trên xe đưa đón học sinh”** được thực hiện nhằm **đảm bảo an toàn cho học sinh** trong quá trình di chuyển, đặc biệt là **ngăn ngừa tình trạng trẻ bị bỏ quên trên xe**.  

Hệ thống sử dụng các công nghệ **IoT**, **Arduino**, **ESP32**, **cảm biến hồng ngoại**, **module SIM800A**, **GPS NEO-6M**, và **OLED** để **phát hiện, cảnh báo và thông báo đến tài xế** khi còn học sinh trong xe sau hành trình.  

---

## Mục tiêu hệ thống  

- Phát hiện học sinh bị bỏ quên trên xe.  
- Gửi **cảnh báo bằng âm thanh, đèn và cuộc gọi điện thoại**.  
- Theo dõi **vị trí và số lượng học sinh** trên xe theo thời gian thực.  
- Giúp phụ huynh và nhà trường **giám sát an toàn và hoạt động đưa đón học sinh**.  

---

## Thành phần phần cứng  

| Thiết bị | Chức năng |
|-----------|------------|
| **Cảm biến hồng ngoại (IR Sensor)** | Phát hiện học sinh lên hoặc xuống xe. |
| **Nút nhấn đơn (Button)** | Dùng để tài xế xác nhận đã kiểm tra xe trước khi rời đi. |
| **Module SIM800A** | Thực hiện cuộc gọi và gửi cảnh báo đến tài xế khi phát hiện có học sinh bị bỏ quên. |
| **Module GPS NEO-6M V2** | Xác định vị trí xe theo thời gian thực. |
| **Màn hình OLED 1.3 inch (I2C)** | Hiển thị trạng thái hệ thống và dữ liệu cảm biến. |
| **ESP32** | Vi điều khiển kết nối WiFi, truyền dữ liệu lên ứng dụng. |
| **Arduino UNO R3** | Xử lý cảm biến và điều khiển module SIM, GPS. |
| **Đèn LED & Buzzer** | Hiển thị cảnh báo bằng âm thanh và ánh sáng. |
| **Nguồn 12VDC – 5VDC** | Cấp nguồn cho toàn hệ thống. |

---

## Phần mềm và công cụ  

- **Arduino IDE** – Lập trình cho Arduino UNO R3 và ESP32.  
- **Ngôn ngữ Java** – Phát triển ứng dụng di động để hiển thị dữ liệu và nhận cảnh báo.  
- **App Android** – Nhận thông báo, hiển thị thông tin và điều khiển hệ thống.  

## Nguyên lý hoạt động  

### 1️. Phát hiện và giám sát  
- Khi học sinh **lên/xuống xe**, cảm biến hồng ngoại đếm số lượng và gửi dữ liệu đến bộ xử lý.  
- **ESP32** hiển thị thông tin trạng thái và số lượng học sinh trên **màn hình OLED**.  
- **GPS** cập nhật vị trí xe theo thời gian thực.  

---

### 2️. Cảnh báo tài xế  
- Khi xe dừng và tài xế nhấn nút **“Stop”**, hệ thống sẽ kiểm tra:  
  - Nếu **còn học sinh trong xe** → **đèn, còi báo động kêu**.  
  - Nếu **tài xế quên bấm nút** → hệ thống **gọi điện tự động qua SIM800A** để cảnh báo.  

---

### 3️. Truyền dữ liệu lên ứng dụng  
- **ESP32** gửi dữ liệu về **số học sinh, vị trí GPS và trạng thái cảm biến** lên ứng dụng di động **mỗi 10 giây**.  
- **Phụ huynh hoặc quản lý** có thể theo dõi thông tin xe trên **App hoặc nền tảng web**.  

---

## Giao diện và chức năng phần mềm  

### Giao diện ứng dụng  
- Hiển thị **tên người dùng**, **số học sinh trên xe**, **trạng thái xe**, **tên tài xế**, **biển số xe**.  
- Cho phép **đăng nhập và đăng ký tài khoản**.  
- Cập nhật **liên tục dữ liệu từ cảm biến** với chu kỳ 10 giây.  

### Chức năng cảnh báo  
- Khi phát hiện **học sinh bị bỏ quên**, hệ thống sẽ **gọi điện ngay cho tài xế**.  
- Đồng thời **hiển thị thông báo trên ứng dụng** và **phát âm thanh cảnh báo tại chỗ**.  

---

## Kết quả đạt được  

- Hoàn thiện mô hình phần cứng và phần mềm điều khiển.  
- Hệ thống chạy ổn định, phản hồi nhanh.  
- Cảnh báo tự động qua **điện thoại và thiết bị trên xe**.  
- Giao diện ứng dụng trực quan, dễ sử dụng.  
- Tích hợp thành công **các module cảm biến, GPS, SIM800A, OLED, ESP32**.  

---

##  Hướng phát triển  

- Đóng gói sản phẩm **nhỏ gọn, an toàn và thẩm mỹ hơn**.  
- Hoàn thiện **tính năng định vị GPS** và hiển thị **lộ trình trên bản đồ**.  
- Tích hợp **AI nhận diện khuôn mặt học sinh** để xác thực danh tính.  
- Bổ sung cảnh báo **qua SMS, Telegram hoặc Email**.  
- Thêm **camera giám sát trong xe** và **lưu trữ lịch sử hành trình**.
