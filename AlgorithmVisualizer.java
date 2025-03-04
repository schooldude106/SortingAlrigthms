import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class AlgorithmVisualizer extends JPanel {
    private int[] array;

    public AlgorithmVisualizer(int size) {
        array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(400) + 10;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        for (int i = 0; i < array.length; i++) {
            g.fillRect(i * 10, getHeight() - array[i], 9, array[i]);
        }
    }

    public void bubbleSort() {
        new Thread(() -> {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        repaint();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    public void mergeSort() {
        new Thread(() -> {
            mergeSortHelper(0, array.length - 1);
        }).start();
    }

    private void mergeSortHelper(int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortHelper(left, mid);
            mergeSortHelper(mid + 1, right);
            merge(left, mid, right);
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void merge(int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }
        System.arraycopy(temp, 0, array, left, temp.length);
    }

    public void quickSort() {
        new Thread(() -> {
            quickSortHelper(0, array.length - 1);
        }).start();
    }

    private void quickSortHelper(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSortHelper(low, pi - 1);
            quickSortHelper(pi + 1, high);
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int partition(int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting Visualizer");
        AlgorithmVisualizer panel = new AlgorithmVisualizer(50);
        frame.add(panel);
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        panel.bubbleSort(); // Change to panel.mergeSort(); or panel.quickSort(); to test different algorithms
    }
}
