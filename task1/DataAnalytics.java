public class DataAnalytics {
    public static void main(String[] args) {
        int[] readings = {15, 42, 7, 89, 33, 24, 50};

        // 1) Total Sum (For Loop)
        int total = 0;
        for (int i = 0; i < readings.length; i++) {
            total += readings[i];
        }
        System.out.println("Total Analytics Sum: " + total);

        // 2) Peak Value (Enhanced For Loop)
        int peak = readings[0];
        for (int value : readings) {
            if (value > peak) {
                peak = value;
            }
        }
        System.out.println("Peak Reading Found: " + peak);

        // 3) High-Intensity Count (While Loop)
        int highIntensityCount = 0;
        int j = 0;
        while (j < readings.length) {
            if (readings[j] > 40) { // Filtering values over 40
                highIntensityCount++;
            }
            j++;
        }
        System.out.println("High Intensity Readings (>40): " + highIntensityCount);

        // 4) Specific Search (If/Else & Break)
        int searchTarget = 89;
        boolean isDetected = false;
        for (int val : readings) {
            if (val == searchTarget) {
                isDetected = true;
                break;
            }
        }
        
        if (isDetected) {
            System.out.println("Target " + searchTarget + " detected in dataset.");
        } else {
            System.out.println("Target " + searchTarget + " not found.");
        }
    }
}
