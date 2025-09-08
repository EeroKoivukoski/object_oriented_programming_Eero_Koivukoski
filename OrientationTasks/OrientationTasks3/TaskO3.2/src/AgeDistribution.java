public class AgeDistribution {
    public static void main(String[] args) {
        final int loops = 1000;
        final int maxAge = 30;

        int[][] ageDistribution = {
                {16, 20},
                {34, 21},
                {52, 22},
                {68, 23},
                {82, 24},
                {89, 25},
                {94, 26},
                {96, 28},
                {100,maxAge}
        };

        int[] generatedAges = new int[maxAge+1];

        // Generate ages according to the distribution:
        for (int i = 1; i <= loops; i++){
            int x = (int)(Math.random()*100)+1; 	// generate a random number 1..100 -> we get the row which gives the age
            int j = 0;
            while (x > ageDistribution[j][0]) j++;
            generatedAges[ageDistribution[j][1]]++;
        }

        // Output the result of the generation:
        System.out.println("|####################|");
        System.out.println("|Age |Count  |%-share|");
        System.out.println("|####################|");
        for (int age = 0; age <= maxAge; age++) {
            if (generatedAges[age] != 0) {
                String str = "|%-4d|%-7d|%-6.2f";
                System.out.printf(str, age, generatedAges[age], ((double)generatedAges[age])/loops*100);
                System.out.print("%|\n");
            }
        }
        System.out.println("|####################|");
    }
}