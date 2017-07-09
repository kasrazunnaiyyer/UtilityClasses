import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CountTriangles {

	public static String[] getUniquePointsFromLines(List<String> lines) {
		Set<String> points = new HashSet<String>();

		for (String line : lines) {
			char[] pointArray = line.toCharArray();
			for (char c : pointArray)
				points.add(c + "");
		}
		String[] pointsArray = new String[points.size()];
		pointsArray = points.toArray(pointsArray);

		return pointsArray;
	}

	public static void printPoints(String[] points) {
		System.out.print("Points Are: ");

		for (int i = 0; i < points.length; i++) {
			System.out.print(points[i] + ", ");
		}
		System.out.println("");
	}

	public static void printLines(List<String> lines) {
		System.out.print("Lines Are: " + lines.toString());
		System.out.println("");

	}

	public static void lookForTriangles(List<String> lines) {
		int count = 0;
		String[] uniquePointsArray = getUniquePointsFromLines(lines);

		printPoints(uniquePointsArray);
		printLines(lines);

		System.out.print("Triangles Are: ");
		for (int a = 0; a < uniquePointsArray.length - 2; a++) {
			for (int b = a + 1; b < uniquePointsArray.length - 1; b++) {
				for (int c = b + 1; c < uniquePointsArray.length; c++) {

					String triangleOption = uniquePointsArray[a] + uniquePointsArray[b] + uniquePointsArray[c];
					boolean isLineOfTriangle1 = false;
					boolean isLineOfTriangle2 = false;
					boolean isLineOfTriangle3 = false;

					for (String line : lines) {
						if (line.contains(uniquePointsArray[a]) && line.contains(uniquePointsArray[b])
								&& !line.contains(uniquePointsArray[c])) {
							isLineOfTriangle1 = true;
						}
						if (line.contains(uniquePointsArray[a]) && line.contains(uniquePointsArray[c])
								&& !line.contains(uniquePointsArray[b])) {
							isLineOfTriangle2 = true;
						}
						if (line.contains(uniquePointsArray[b]) && line.contains(uniquePointsArray[c])
								&& !line.contains(uniquePointsArray[a])) {
							isLineOfTriangle3 = true;
						}
					}
					if (isLineOfTriangle1 && isLineOfTriangle2 && isLineOfTriangle3) {
						count++;
						System.out.print(triangleOption + ", ");
					}
				}
			}
		}
		System.out.println("\n\nNumber Of Triangles = " + count);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert No. of lines..");
		int count = Integer.parseInt(scanner.nextLine());

		List<String> lines = new ArrayList<String>();

		for (int i = 0; i < count; i++) {
			System.out.print("Line " + (i + 1) + " :");
			lines.add(scanner.nextLine());
		}

		lookForTriangles(lines);
	}

}
