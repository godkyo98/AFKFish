# 🎣 AFKFish

![Minecraft Version](https://img.shields.io/badge/Minecraft-26.2%20%7C%2026.3-2ea44f?style=for-the-badge&logo=minecraft)
![Platform](https://img.shields.io/badge/Fabric-Client--Side-E3C95A?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

**AFKFish** là một mod Fabric hoạt động hoàn toàn ở phía Client, tự động giật cần và quăng lại dây câu ngay khi cá cắn câu, giúp trải nghiệm câu cá AFK trở nên tiện lợi, an toàn và tối ưu nhất.

---

## ✨ Tính Năng Nổi Bật

* 🔄 **Vòng lặp tự động (Auto Reel & Recast):** Tự động nhận diện thời điểm cá cắn câu để thu cần và thả lại mồi tức thì.
* 🎒 **Xoay vòng nhiều cần (MultiRod Hotbar Cycling):** Tự động đổi sang cần câu tiếp theo trên thanh hotbar khi cần hiện tại hết độ bền hoặc cần thay thế[cite: 3].
* 🛡️ **Bảo vệ cần câu (Rod Break Protection):** Tự động ngừng sử dụng hoặc chuyển cần khi độ bền giảm xuống mức báo động, chống gãy cần câu xịn[cite: 3].
* ⏱️ **Chế độ duy trì (Persistent Mode):** Giữ trạng thái câu cá luôn hoạt động ổn định và liên tục[cite: 3].
* 🔊 **Nhận diện âm thanh nhiều người chơi (Multiplayer Sound Detection):** Bắt chính xác âm thanh cắn câu của chính bạn ngay cả trong môi trường máy chủ đông người[cite: 3].
* 🧹 **Hỗ trợ mẫu chat ClearLag:** Tự động phát hiện các thông báo dọn dẹp rác sàn của ClearLag để tự quăng lại cần sau khi phao câu bị xóa[cite: 3].
* ⚙️ **Tùy biến trực quan:** Tích hợp giao diện cài đặt trong game tiện lợi, hỗ trợ tùy chỉnh phím tắt và tương thích hoàn toàn với **Mod Menu**[cite: 3].
* 🌐 **Hỗ trợ đa ngôn ngữ:** Tích hợp sẵn nhiều gói ngôn ngữ bao gồm Tiếng Việt (`vi_vn`), Tiếng Anh (`en_us`, `en_gb`), v.v.

---

## 📌 Khả Năng Tương Thích

* **Minecraft:** Hỗ trợ các phiên bản `26.2` và `26.3`
* **Fabric Loader:** `>= 0.18.5`[cite: 3]
* **Java:** Phiên bản Java tương thích với phiên bản game (Java 21 / Java 25)[cite: 3]

---

## 📥 Hướng Dẫn Cài Đặt

1. Cài đặt **Fabric Loader** phiên bản phù hợp cho bản Minecraft bạn đang chơi[cite: 3].
2. Cài đặt **Fabric API** vào thư mục `mods`[cite: 3].
3. *(Tùy chọn)* Cài đặt **Cloth Config** để sử dụng giao diện cấu hình trực quan trong game[cite: 3].
4. *(Tùy chọn)* Cài đặt **Mod Menu** để mở cài đặt mod trực tiếp từ danh sách mod[cite: 3].
5. Tải tệp `.jar` của **AFKFish** và bỏ vào thư mục `.minecraft/mods` của bạn[cite: 3].

---

## 🎮 Phím Tắt & Điều Khiển

* Nhấn phím **`V`** (mặc định) để mở giao diện cài đặt cấu hình Autofish trong game[cite: 3].
* Phím bấm có thể thay đổi tùy ý trong phần **Tùy chọn -> Điều khiển (Controls)** của Minecraft.

---

## 🔨 Hướng Dẫn Tự Build Mod

Dành cho nhà phát triển muốn tự biên dịch mod từ mã nguồn:

```bash
# Đối với Linux / macOS
./gradlew build

# Đối với Windows
gradlew.bat build
