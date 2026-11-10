# Food Review — Session 3 (Lists, Fragments & Navigation)

**Họ và tên:** Trần Đức Anh  
**MSSV:** 24110155  
**Môn học:** Lập trình Di động (Android) — Session 3: Lists, Fragments & Navigation  
**Package:** `vn.edu.course.foodreview`

---

## Tính năng đã hoàn thành (Session 3 Acceptance Criteria & Stretch Task)

1. **Danh sách quán ăn với `RecyclerView`, `ListAdapter` & `DiffUtil` (Slides 7–16, 40):**
   - Hiển thị 8 quán ăn mẫu (`SampleRestaurants`) với `MaterialCardView` (`Widget.Material3.CardView.Elevated`) cho mỗi dòng gồm: Tên quán (`name`), Ẩm thực (`cuisine`), Quận/Khu vực (`district`), Điểm đánh giá (`rating`) và biểu tượng yêu thích.
   - Sử dụng `ListAdapter<Restaurant, RestaurantViewHolder>` kết hợp `DiffUtil.ItemCallback<Restaurant>`:
     - `areItemsTheSame`: so sánh `id`.
     - `areContentsTheSame`: sử dụng `equals()`.
   - Mọi cập nhật danh sách đều đi qua `submitList(...)`, tuyệt đối không dùng `notifyDataSetChanged()`.
   - Tự động chuyển từ 1 cột (Portrait) sang 2 cột (Landscape / Tablet `sw600dp`) thông qua `@integer/restaurant_columns` và `GridLayoutManager`.

2. **Single-Activity Architecture, `Fragment` Lifecycle & View Binding (Slides 17–21, 42):**
   - `MainActivity` đóng vai trò host duy nhất chứa `MaterialToolbar`, `NavHostFragment` và `BottomNavigationView`.
   - Tất cả Fragment (`RestaurantListFragment`, `FavouritesFragment`, `RestaurantDetailFragment`) đều sử dụng **View Binding** (`viewBinding = true`), không dùng `findViewById`, và giải phóng `binding = null` trong `onDestroyView()`.
   - Quan sát `LiveData` với `getViewLifecycleOwner()` trong `onViewCreated()`.

3. **Jetpack Navigation Component & Safe Args (Slides 22–29, 40):**
   - Đồ thị điều hướng `res/navigation/nav_graph.xml` định nghĩa 3 destination (`restaurantListFragment`, `favouritesFragment`, `restaurantDetailFragment`).
   - Khi chạm vào một thẻ quán ăn, ứng dụng điều hướng sang `RestaurantDetailFragment` thông qua Safe Args (`RestaurantListFragmentDirections` / `FavouritesFragmentDirections`), **chỉ truyền duy nhất `restaurantId` (`String`)**, không truyền toàn bộ đối tượng `Restaurant`.
   - Nhấn nút Back từ màn hình Chi tiết quay về đúng vị trí cuộn của danh sách trước đó.

4. **Màn hình Chi tiết & Implicit Intent `ACTION_DIAL` (Slides 30–35, 40):**
   - Tra cứu `Restaurant` theo `restaurantId` từ `RestaurantViewModel` và hiển thị đầy đủ thông tin, giữ nguyên trạng thái khi xoay màn hình.
   - Nút **Call (`Gọi điện`)** mở ứng dụng gọi điện hệ thống với số điện thoại điền sẵn bằng `Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))`, **không yêu cầu quyền `CALL_PHONE`** trong `AndroidManifest.xml`, và bắt `ActivityNotFoundException` để hiển thị `Snackbar` (`R.string.no_dialler`).
   - Nút **Share (`Chia sẻ`)** sử dụng `Intent.ACTION_SEND` với `Intent.createChooser(...)`.

5. **Stretch Task — BottomNavigationView & Favourites (Slide 41):**
   - `BottomNavigationView` gồm 2 tab: **Restaurants (`Quán ăn`)** và **Favourites (`Yêu thích`)** với menu ID trùng khớp destination ID trong `nav_graph.xml`.
   - Cho phép đánh dấu / bỏ đánh dấu yêu thích trực tiếp trên màn hình Chi tiết; danh sách yêu thích được lưu trong bộ nhớ qua `RestaurantViewModel` và giữ nguyên khi xoay màn hình.

6. **Đa ngôn ngữ & Accessibility (Slide 42):**
   - Đầy đủ chuỗi tiếng Anh (`res/values/strings.xml`) và tiếng Việt có dấu (`res/values-vi/strings.xml`).
   - Các nút chức năng có `contentDescription` và chiều cao chạm tối thiểu `48dp`.
