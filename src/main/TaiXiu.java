package main;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/*
 *Mot nguoi choi se co tai khoan. Nguoi choi co quyen dat cuoc so tien it hon hoac bang 
 * so tien ho dang co
 * Luat choi nhu sau
 * Co 3 vien xuc xac .Moi vien xuc xac co 6 mat co gia tri tu 1 den 6 
 * Moi lan lac se ra mot ket qua. Ket qua = gia tri xx1 + gia tri xx2+ gia tri xx3
 * 1 . Neu tong = 3 hoac 18 => Cai an het ,nguoi choi thua
 * 2 . Neu tong = (4->10) <-> Xiu => neu nguoi choi dat xiu thi nguoi choi thang, nguoc lai thua
 * 3 . Neu tong = (11->17) <-> Tai => neu nguoi choi dat tai thi nguoi choi thang ,nguoc lai thua 
 */

public class TaiXiu {
	public static void main(String[] args) {

		double taiKhoanNguoiChoi = 5000000;
		Scanner sc = new Scanner(System.in);

		Locale lc = new Locale("vi", "VN");
		// Locale lc = new Locale("en", "US");
		// NumberFormat numf = NumberFormat.getInstance(lc);
		NumberFormat numf = NumberFormat.getCurrencyInstance(lc);
		int luachon = 0;
		do {
			System.out.println("♥♥♥♥♥♥♥♥ MỜI BẠN LỰA CHỌN ◆◆◆◆◆◆◆◆");
			System.out.println("◩ Chọn ➊ để tiếp tục chơi . ");
			System.out.println("◩ Chọn (phím bất kỳ ┊͙┊͙┊͙ ) để thoát .");
			luachon = sc.nextInt();
			if (luachon == 1) {
				System.out.println(" ◕ ‿ ◕ BẮT ĐẦU TRÒ CHƠI ◕ ‿ ◕");
				// Dat cuoc
				System.out.println(" ☞☞☞☞☞ TÀI KHOẢN CỦA BẠN LÀ : " + numf.format(taiKhoanNguoiChoi)
						+ ", BẠN MUỐN CƯỢC BAO NHIÊU ? ۞ ");
				double datCuoc = 0;
				do {
					System.out
							.println(" ☞☞☞☞☞ ĐẶT CƯỢC (0 < SỐ TIỀN CƯỢC <= " + numf.format(taiKhoanNguoiChoi) + ") : ");
					datCuoc = sc.nextDouble();

				} while (datCuoc <= 0 || datCuoc > taiKhoanNguoiChoi);

				// Chon tai xiu
				int luaChonTaiXiu = 0;
				do {
					System.out.println(" ♚♚♚♚♚♚ Chọn : 1 ➯ Tài ▩▩▩ 2 ➯ Xỉu ︻┳デ═—  ⍰ ⍰ ⍰");
					luaChonTaiXiu = sc.nextInt();

				} while (luaChonTaiXiu != 1 && luaChonTaiXiu != 2);

				// Tung xuc xac
				Random xucXac1 = new Random();
				Random xucXac2 = new Random();
				Random xucXac3 = new Random();

				int giaTri1 = xucXac1.nextInt(5) + 1; // random con so 0 -> 5 (+1 do xuc xac la mat 1 den 6 )
				int giaTri2 = xucXac2.nextInt(5) + 1;
				int giaTri3 = xucXac3.nextInt(5) + 1;

				int tong = giaTri1 + giaTri2 + giaTri3;

				// Tinh toan ket qua
				System.out.println("<,︻╦╤─ ҉ – – Kết quả : " + giaTri1 + " ◈ " + giaTri2 + " ◈ " + giaTri3);
				if (tong == 3 || tong == 18) {
					taiKhoanNguoiChoi -= datCuoc;
					System.out.println("☞☞☞☞☞ Tổng là : " + tong + " =>  (҂`_´) Nhà cái ăn hết, bạn đã thua HAHA ! ⊙﹏⊙ ");
					System.out.println("☞☞☞☞☞ Tài khoản hiện tại của ban là : " + numf.format(taiKhoanNguoiChoi));

				} else if (tong >= 4 && tong <= 10) {

					System.out.println("☞☞☞☞☞ Tổng là : " + tong + " ︻┳デ═— Xỉu ");
					if (luaChonTaiXiu == 2) {
						System.out.println("⚃ ⚄ ⚅ ⚀ ⚁ ⚂ Bạn đã thắng cược ⚃ ⚄ ⚅ ⚀ ⚁ ⚂ ");
						taiKhoanNguoiChoi += datCuoc;
						System.out.println("☞☞☞☞☞ Tài khoản hiện tại của ban là : " + numf.format(taiKhoanNguoiChoi));
					} else {
						System.out.println("✘✘✘✘✘✘ Bạn đã thua cược ✘✘✘✘✘✘ ");
						taiKhoanNguoiChoi -= datCuoc;
						System.out.println("☞☞☞☞☞ Tài khoản hiện tại của ban là : " + numf.format(taiKhoanNguoiChoi));
					}
				} else {
					System.out.println("******* Tổng là : " + tong + " ︻┳デ═— Tài ");
					if (luaChonTaiXiu == 1) {
						System.out.println("⚃ ⚄ ⚅ ⚀ ⚁ ⚂ Bạn đã thắng cược ⚃ ⚄ ⚅ ⚀ ⚁ ⚂ ");
						taiKhoanNguoiChoi += datCuoc;
						System.out.println("☞☞☞☞☞ Tài khoản hiện tại của ban là : " + numf.format(taiKhoanNguoiChoi));
					} else {
						System.out.println("✘✘✘✘✘✘ Bạn đã thua cược ✘✘✘✘✘✘");
						taiKhoanNguoiChoi -= datCuoc;
						System.out.println("☞☞☞☞☞ Tài khoản hiện tại của ban là : " + numf.format(taiKhoanNguoiChoi));
					}
				}

			}

		} while (luachon == 1);

	}
}
