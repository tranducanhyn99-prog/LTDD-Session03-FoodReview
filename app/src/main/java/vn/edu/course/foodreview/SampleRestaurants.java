package vn.edu.course.foodreview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Provides an expanded list of 20 sample restaurants across HCMC for Session 3,
 * ensuring the list extends well beyond a single viewport so scrolling and
 * scroll-position restoration on Back navigation (Slide 40) can be thoroughly tested.
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
            ),
            new Restaurant(
                    "rest_09",
                    "Dim Tu Tac Đông Du",
                    "Ẩm Thực Quảng Đông",
                    "Quận 1",
                    "02838266668",
                    "55 Đông Du, Phường Bến Nghé, Quận 1, TP.HCM",
                    4.7,
                    "Nhà hàng ẩm thực Quảng Đông hiện đại nổi tiếng với há cảo tôm tươi, bánh bao kim sa, vịt quay Bắc Kinh da giòn và chân gà tàu xì.",
                    10.7761,
                    106.7042,
                    true
            ),
            new Restaurant(
                    "rest_10",
                    "Bún Chả Ánh Hồng",
                    "Đặc Sản Hà Nội",
                    "Quận Phú Nhuận",
                    "02839904478",
                    "140B Phan Đình Phùng, Phường 2, Quận Phú Nhuận, TP.HCM",
                    4.4,
                    "Bún chả Hà Nội nướng than hoa thơm nức mũi với chả miếng, chả viên nướng mềm ngọt ngập trong bát nước mắm đu đủ chua ngọt.",
                    10.7952,
                    106.6836,
                    false
            ),
            new Restaurant(
                    "rest_11",
                    "Lẩu Dê Trương Định",
                    "Đặc Sản Lẩu Dê",
                    "Quận 3",
                    "02839304296",
                    "105 Trương Định, Phường Võ Thị Sáu, Quận 3, TP.HCM",
                    4.5,
                    "Quán lẩu dê lâu năm trứ danh với nước lẩu đậm đà vị thuốc bắc, thịt dê nướng ngũ vị, vú dê nướng giòn sần sật chấm chao béo ngậy.",
                    10.7788,
                    106.6908,
                    false
            ),
            new Restaurant(
                    "rest_12",
                    "Quán Bụi - Authentic Vietnamese",
                    "Cơm Gia Đình",
                    "Quận 1",
                    "02838291299",
                    "19 Ngô Văn Năm, Phường Bến Nghé, Quận 1, TP.HCM",
                    4.6,
                    "Ẩm thực Việt Nam truyền thống không sử dụng bột ngọt với các món chả giò giòn rụm, sườn xào chua ngọt và canh cua rau đay thanh mát.",
                    10.7801,
                    106.7056,
                    true
            ),
            new Restaurant(
                    "rest_13",
                    "Chè Mâm Khánh Vy",
                    "Tráng Miệng & Chè",
                    "Quận 10",
                    "0909383829",
                    "242B Sư Vạn Hạnh, Phường 2, Quận 10, TP.HCM",
                    4.3,
                    "Mâm chè 16 món hấp dẫn gồm chè đậu trắng, chè thưng, chè mè đen, chè trôi nước bà ba phục vụ kèm nước cốt dừa sánh mịn.",
                    10.7601,
                    106.6713,
                    false
            ),
            new Restaurant(
                    "rest_14",
                    "Bún Mắm Sáu Khánh",
                    "Đặc Sản Miền Tây",
                    "Quận 10",
                    "02838630048",
                    "363 Lê Hồng Phong, Phường 2, Quận 10, TP.HCM",
                    4.5,
                    "Tô bún mắm miền Tây thơm lừng đậm đà nấu từ mắm cá linh cá sặc với tôm sú tươi rói, mực giòn, heo quay da giòn và rau đắng cà tím.",
                    10.7634,
                    106.6738,
                    false
            ),
            new Restaurant(
                    "rest_15",
                    "Bò Tơ Quán Mộc",
                    "Đặc Sản Bò Tơ",
                    "Quận Bình Thạnh",
                    "1900636882",
                    "43-45 Nguyễn Thị Thập, Phường Tân Hưng, Quận 7, TP.HCM",
                    4.6,
                    "Bò tơ non mềm ngọt thịt với các món bò tơ cuốn bánh tráng rau rừng, bò nướng tảng than hoa và lẩu riêu cua bắp bò.",
                    10.7425,
                    106.7041,
                    true
            ),
            new Restaurant(
                    "rest_16",
                    "Cháo Lòng Bà Út",
                    "Món Ăn Truyền Thống",
                    "Quận 1",
                    "0903678123",
                    "193 Cô Giang, Phường Cô Giang, Quận 1, TP.HCM",
                    4.5,
                    "Hơn 80 năm phục vụ cháo lòng truyền thống nấu với huyết tươi thơm ngọt, dồi trường giòn sần sật và nước mắm ớt cay xè chuẩn vị Sài Gòn xưa.",
                    10.7621,
                    106.6942,
                    false
            ),
            new Restaurant(
                    "rest_17",
                    "Hủ Tiếu Mì Thiệu Ký",
                    "Mì Kéo Gia Truyền Chợ Lớn",
                    "Quận 11",
                    "02838555234",
                    "66/5 Lê Đại Hành, Phường 7, Quận 11, TP.HCM",
                    4.6,
                    "Gia tộc làm mì tươi người Hoa hơn 70 năm với sợi mì trứng giòn dai, sủi cảo nhân tôm thịt chắc nịch và nước lèo xương hầm ngọt thanh.",
                    10.7628,
                    106.6547,
                    false
            ),
            new Restaurant(
                    "rest_18",
                    "Cơm Gà Đông Nguyên",
                    "Cơm Gà Hải Nam Chợ Lớn",
                    "Quận 5",
                    "02838557662",
                    "801 Nguyễn Trãi, Phường 14, Quận 5, TP.HCM",
                    4.5,
                    "Thương hiệu cơm gà lâu đời Chợ Lớn với gà luộc da vàng giòn dai, cơm nấu mỡ gà thơm dẻo và chén canh cải chua hầm giò heo đậm vị.",
                    10.7516,
                    106.6601,
                    true
            ),
            new Restaurant(
                    "rest_19",
                    "Gỏi Cuốn Tôm Nhảy Lạc Long Quân",
                    "Ăn Vặt Sài Gòn",
                    "Quận 11",
                    "0908123456",
                    "354 Lạc Long Quân, Phường 5, Quận 11, TP.HCM",
                    4.4,
                    "Gỏi cuốn chắc tay với tôm sú tươi luộc đỏ âu, thịt ba chỉ nạc mỡ đan xen, cuốn kèm rau thơm và chấm tương đen bơ đậu phộng béo bùi.",
                    10.7678,
                    106.6452,
                    false
            ),
            new Restaurant(
                    "rest_20",
                    "Súp Cua Hạnh",
                    "Ăn Vặt & Món Khai Vị",
                    "Quận 10",
                    "0938123789",
                    "549 Sư Vạn Hạnh, Phường 13, Quận 10, TP.HCM",
                    4.5,
                    "Tô súp cua sánh đặc đầy ắp thịt cua tươi, trứng cút, bắp ngọt, óc heo béo ngậy và trứng bắc thảo đậm đà ăn kèm ớt sa tế.",
                    10.7752,
                    106.6685,
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
