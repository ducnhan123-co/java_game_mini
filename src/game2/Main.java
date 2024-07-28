package game2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] movies = {
                "The Shawshank Redemption",
                "The Godfather",
                "The Dark Knight",
                "Schindler's List",
                "Pulp Fiction",
                "The Lord of the Rings",
                "The Good, the Bad and the Ugly",
                "Fight Club",
                "The Lord of the Rings",
                "Forrest Gump",
                "Star Wars",
                "Inception",
                "The Lord of the Rings",
                "The Matrix",
                "Samurai",
                "Star Wars",
                "City of God",
                "The Silence of the Lambs",
                "Batman Begins",
                "Die Hard",
                "Chinatown",
                "Room",
                "Dunkirk",
                "Fargo",
                "No Country for Old Men"
        };


        int randomNumber = (int) (Math.random() * movies.length); //Đếm từ 0
        String selectedMovie = movies[randomNumber];
        String hiddenMovie = chuyenStringThanhGachDuoi(selectedMovie);
        char[] hiddenMovieArray = hiddenMovie.toCharArray();
        char[] selectedMovieArray = selectedMovie.toCharArray();
        Scanner scanner = new Scanner(System.in);
        int luaChon = 0;
        do {
            int attempts = 14;
            int score = 0;
            System.out.println("♥♥♥♥♥♥♥♥ MỜI BẠN LỰA CHỌN ◆◆◆◆◆◆◆◆");
            System.out.println("◩ Chọn 1 để tiếp tục chơi . ");
            System.out.println("◩ Chọn (phím bất kỳ ┊͙┊͙┊͙ ) để thoát .");
            luaChon = scanner.nextInt();
            scanner.nextLine();
            if (luaChon == 1) {
                while (true) {
                    System.out.println("Bạn chỉ có: " + attempts + " lần đoán phim và " + score + " điểm.");
                    System.out.println("Phim đã được tạo ngẫu nhiên: " + new String(hiddenMovieArray));
                    System.out.println("Mời bạn đoán một chữ của phim:");
                    String guess = scanner.nextLine();
                    if (guess.length() != 1) {
                        System.out.println("Vui lòng nhập 1 chữ cái. ");
                        continue;
                    }

                    char guessedChar = guess.charAt(0);
                    boolean found = false;
                    for (int i = 0; i < selectedMovieArray.length; i++) {
                        if (Character.toLowerCase(selectedMovieArray[i]) == Character.toLowerCase(guessedChar)) {
                            hiddenMovieArray[i] = selectedMovieArray[i];
                            found = true;
                        }
                    }
                    if (found) {
                        attempts--;
                        score++;
                        System.out.println("Bạn đã đoán đúng một chữ cái: " + guessedChar);
                        System.out.println("Phim hiện tại là: " + new String(hiddenMovieArray));
                    } else {
                        attempts--;
                        //  score--;
                        System.out.println("Chữ cái bạn đoán không có trong phim.");
                    }
                    if (new String(hiddenMovieArray).equals(selectedMovie)) {
                        System.out.println("Chúc mừng ! Bạn đã đoán đúng toàn bộ tên phim ");
                        break;
                    }
                    if (attempts == 0) {
                        System.out.println("Ban đã hết lượt đoán ");
                        System.out.println("Bạn đã thua cuộc ");
                        break;
                    }

                }
            }
        }while (luaChon == 1);
    }

    public static String chuyenStringThanhGachDuoi(String movie) {
        return movie.replaceAll("[a-zA-Z]", "_");
    }
}