import java.time.LocalTime;

public class TalkingClock {
    public static void main(String[] args) {
        try {
            LocalTime inputTime = null;

            if (args.length > 0) {
                String[] timeParts = args[0].split(":");
                if (timeParts.length == 2) {
                    int hour = Integer.parseInt(timeParts[0]);
                    int minute = Integer.parseInt(timeParts[1]);

                    if (hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59) {
                        inputTime = LocalTime.of(hour, minute);
                    } else {
                        System.out.println("Invalid time format. Please provide a valid time in hh:mm format.");
                        return;
                    }
                } else {
                    System.out.println("Invalid time format. Please provide a valid time in hh:mm format.");
                    return;
                }
            } else {
                inputTime = LocalTime.now();
            }

            String humanFriendlyTime = convertToHumanFriendlyText(inputTime);
            System.out.println(humanFriendlyTime);
        } catch (NumberFormatException e) {
            System.out.println("Invalid time format. Please provide a valid time in hh:mm format.");
        }
    }

    public static String convertToHumanFriendlyText(LocalTime time) {
        int hour = time.getHour() % 12;
        int minute = time.getMinute();

        String[] numbers = {
                "Twelve", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven"
        };

        String[] minutes = {
                "o'clock", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen", "Twenty", "Twenty one", "Twenty two", "Twenty three",
                "Twenty four", "Twenty five", "Twenty six", "Twenty seven", "Twenty eight", "Twenty nine"
        };

        String timeText = "";

        if (minute == 0) {
            timeText = numbers[hour] + " " + minutes[minute];
        } else if (minute <= 30) {
            if (minute == 15) {
                timeText = "Quarter past " + numbers[hour];
            } else if (minute == 30) {
                timeText = "Half past " + numbers[hour];
            } else {
                timeText = minutes[minute] + " past " + numbers[hour];
            }
        } else {
            if (minute == 45) {
                timeText = "Quarter to " + numbers[(hour + 1) % 12];
            } else {
                timeText = minutes[60 - minute] + " to " + numbers[(hour + 1) % 12];
            }
        }

        return timeText;
    }
}
