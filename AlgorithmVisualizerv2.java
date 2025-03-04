import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class AlgorithmVisualizerv2 extends JPanel {
    private int[][] arrays;
    private final int numAlgorithms = 3;

    public AlgorithmVisualizerv2(int size) {
        arrays = new int[numAlgorithms][size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int value = rand.nextInt(400) + 10;
            for (int j = 0; j < numAlgorithms; j++) {
                arrays[j][i] = value;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth() / numAlgorithms;
        Color[] colors = {Color.BLUE, Color.RED, Color.GREEN};
        for (int k = 0; k < numAlgorithms; k++) {
            g.setColor(colors[k]);
            for (int i = 0; i < arrays[k].length; i++) {
                g.fillRect(k * width + i * 10, getHeight() - arrays[k][i], 9, arrays[k][i]);
            }
        }
    }

    public void startSorting() {
        new Thread(() -> bubbleSort(0)).start();
        new Thread(() -> mergeSort(1, 0, arrays[1].length - 1)).start();
        new Thread(() -> quickSort(2, 0, arrays[2].length - 1)).start();
    }

    private void bubbleSort(int index) {
        for (int i = 0; i < arrays[index].length - 1; i++) {
            for (int j = 0; j < arrays[index].length - i - 1; j++) {
                if (arrays[index][j] > arrays[index][j + 1]) {
                    swap(index, j, j + 1);
                }
            }
        }
    }

    private void mergeSort(int index, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(index, left, mid);
            mergeSort(index, mid + 1, right);
            merge(index, left, mid, right);
            repaint();
            sleep();
        }
    }

    private void merge(int index, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arrays[index][i] <= arrays[index][j]) {
                temp[k++] = arrays[index][i++];
            } else {
                temp[k++] = arrays[index][j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arrays[index][i++];
        }
        while (j <= right) {
            temp[k++] = arrays[index][j++];
        }
        System.arraycopy(temp, 0, arrays[index], left, temp.length);
    }

    private void quickSort(int index, int low, int high) {
        if (low < high) {
            int pi = partition(index, low, high);
            quickSort(index, low, pi - 1);
            quickSort(index, pi + 1, high);
            repaint();
            sleep();
        }
    }

    private int partition(int index, int low, int high) {
        int pivot = arrays[index][high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arrays[index][j] < pivot) {
                i++;
                swap(index, i, j);
            }
        }
        swap(index, i + 1, high);
        return i + 1;
    }

    private void swap(int index, int i, int j) {
        int temp = arrays[index][i];
        arrays[index][i] = arrays[index][j];
        arrays[index][j] = temp;
        repaint();
        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting Visualizer");
        AlgorithmVisualizerv2 panel = new AlgorithmVisualizerv2(50);
        frame.add(panel);
        frame.setSize(1500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        panel.startSorting();
    }
}
