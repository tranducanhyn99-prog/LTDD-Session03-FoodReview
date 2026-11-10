package vn.edu.course.foodreview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Provides sample restaurant data for Session 3 before Room persistence is introduced in Session 4.
 */
public final class SampleRestaurants {

    private static final List<Restaurant> ITEMS = Collections.unmodifiableList(Arrays.asList(
            new Restaurant(
                    "rest_01",
                    "Phở Hòa Pasteur",
                    "Phở & Món Việt",
                    "Quận 3",
                    "02838297943",
                    "260C Pasteur, Phường Võ Thị Sáu, Quận 3, TP.HCM",
                    4.7,
                    "Quán phở truyền thống lâu đời từ năm 1968 tại Sài Gòn với nước dùng ninh xương đậm đà, thịt bò tươi mềm và đĩa rau sống phong phú.",
                    10.7868,
                    106.6881,
                    true
            ),
            new Restaurant(
                    "rest_02",
                    "Cơm Tấm Ba Ghiền",
                    "Cơm Tấm Sài Gòn",
                    "Quận Phú Nhuận",
                    "02838445839",
                    "84 Đặng Văn Ngữ, Phường 10, Quận Phú Nhuận, TP.HCM",
                    4.6,
                    "Nổi tiếng với miếng sườn nướng khổng lồ ướp đậm vị, bì chả làm thủ công, ăn kèm mỡ hành và đồ chua giòn ngon.",
                    10.7939,
                    106.6698,
                    true
            ),
            new Restaurant(
                    "rest_03",
                    "Bánh Mì Huỳnh Hoa",
                    "Bánh Mì Việt Nam",
                    "Quận 1",
                    "02839250885",
                    "26 Lê Thị Riêng, Phường Bến Thành, Quận 1, TP.HCM",
                    4.5,
                    "Bánh mì đặc ruột giòn rụm kẹp đầy ắp chả lụa, thịt nguội, chà bông, pate gan béo ngậy và bơ gia truyền đặc trưng.",
                    10.7716,
                    106.6915,
                    false
            ),
            new Restaurant(
                    "rest_04",
                    "Bún Bò Huế Đông Ba",
                    "Đặc Sản miền Trung",
                    "Quận 1",
                    "02838238709",
                    "207A Nguyễn Văn Thủ, Phường Đa Kao, Quận 1, TP.HCM",
                    4.6,
                    "Hương vị bún bò Huế chuẩn mực với nước lèo thơm mùi sả và mắm ruốc, giò heo mềm, chả cua tươi và rau chuối bào.",
                    10.7885,
                    106.6982,
                    false
            ),
            new Restaurant(
                    "rest_05",
                    "Pizza 4P's Lê Thánh Tôn",
                    "Ẩm Thực Ý - Nhật",
                    "Quận 1",
                    "19006043",
                    "8/15 Lê Thánh Tôn, Phường Bến Nghé, Quận 1, TP.HCM",
                    4.8,
                    "Pizza nướng củi thủ công kết hợp phô mai Burrata tự làm tại Đà Lạt, mì Ý cua sốt kem cà chua và không gian ấm cúng.",
                    10.7797,
                    106.7048,
                    true
            ),
            new Restaurant(
                    "rest_06",
                    "Bánh Xèo 46A Đinh Công Tráng",
                    "Bánh Xèo Nam Bộ",
                    "Quận 1",
                    "02838241110",
                    "46A Đinh Công Tráng, Phường Tân Định, Quận 1, TP.HCM",
                    4.4,
                    "Bánh xèo chảo gang vành mỏng giòn tan nhân tôm thịt, giá đỗ và đậu xanh, cuốn cùng cải bẹ xanh và nước mắm chua ngọt.",
                    10.7894,
                    106.6904,
                    false
            ),
            new Restaurant(
                    "rest_07",
                    "Cục Gạch Quán",
                    "Cơm Nhà Việt Nam",
                    "Quận 1",
                    "02838480144",
                    "10 Đặng Tất, Phường Tân Định, Quận 1, TP.HCM",
                    4.7,
                    "Thực đơn cơm gia đình miền quê Việt Nam với đậu hũ chiên sả ớt, cá kho tộ, canh chua cá lóc trong biệt thự cổ yên bình.",
                    10.7918,
                    106.6897,
                    false
            ),
            new Restaurant(
                    "rest_08",
                    "Hủ Tiếu Nam Vang Nhân Quán",
                    "Hủ Tiếu & Mì",
                    "Quận 3",
                    "02839311578",
                    "122D Cách Mạng Tháng Tám, Phường Võ Thị Sáu, Quận 3, TP.HCM",
                    4.5,
                    "Hủ tiếu khô và nước với sợi hủ tiếu dai mềm, tôm tươi, thịt bằm, trứng cút và nước sốt trộn đậm đà kèm tỏi phi thơm lừng.",
                    10.7779,
                    106.6845,
                    false
            )
    ));

    private SampleRestaurants() {
        // Utility class
    }

    @NonNull
    public static List<Restaurant> all() {
        return ITEMS;
    }

    @Nullable
    public static Restaurant findById(@NonNull String id) {
        for (Restaurant r : ITEMS) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }
}
