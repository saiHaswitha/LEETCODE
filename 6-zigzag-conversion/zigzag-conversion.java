class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        int cycleLength = (numRows - 1) * 2;
        StringBuilder output = new StringBuilder(s.length());

        for (int row = 0; row < numRows; row++) {
            for (
                int verticalIndex = row;
                verticalIndex < s.length();
                verticalIndex += cycleLength
            ) {
                // Вертикальная буква
                output.append(s.charAt(verticalIndex));

                // Диагональная буква
                int diagonalIndex =
                    verticalIndex + cycleLength - 2 * row;

                boolean middleRow =
                    row > 0 && row < numRows - 1;

                if (middleRow && diagonalIndex < s.length()) {
                    output.append(s.charAt(diagonalIndex));
                }
            }
        }

        return output.toString();
    }
}