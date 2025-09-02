# Sorting Algorithm Visualizer

A Java Swing application that provides real-time visualization of popular sorting algorithms. Watch as different sorting techniques organize random data through animated bar charts.

## Features

- **Real-time Animation**: Visual representation of sorting algorithms in action
- **Multiple Algorithms**: Bubble Sort, Merge Sort, and Quick Sort implementations
- **Two Versions**: Single algorithm viewer and side-by-side comparison
- **Customizable**: Adjustable array size and animation speed

## Programs Included

### 1. AlgorithmVisualizer.java
A single-panel visualizer that demonstrates one sorting algorithm at a time.

**Features:**
- Clean, focused view of individual algorithms
- Blue bar visualization
- Easy algorithm switching via code modification
- 50 elements with 600×500 window

### 2. AlgorithmVisualizerv2.java  
An advanced multi-panel visualizer that runs three sorting algorithms simultaneously.

**Features:**
- Side-by-side comparison of all three algorithms
- Color-coded panels (Blue: Bubble Sort, Red: Merge Sort, Green: Quick Sort)
- Concurrent execution using multithreading
- 50 elements per algorithm with 1500×500 window

## Algorithms Implemented

### Bubble Sort
- **Time Complexity**: O(n²)
- **Space Complexity**: O(1)
- **Description**: Compares adjacent elements and swaps if they're in wrong order

### Merge Sort
- **Time Complexity**: O(n log n)
- **Space Complexity**: O(n)
- **Description**: Divide-and-conquer algorithm that splits array and merges sorted halves

### Quick Sort
- **Time Complexity**: O(n log n) average, O(n²) worst case
- **Space Complexity**: O(log n)
- **Description**: Selects pivot element and partitions array around it

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE or command line compiler

### Compilation and Execution

#### Command Line:
```bash
# Compile
javac AlgorithmVisualizer.java
javac AlgorithmVisualizerv2.java

# Run single algorithm visualizer
java AlgorithmVisualizer

# Run multi-algorithm comparison
java AlgorithmVisualizerv2
```

#### IDE:
1. Import the Java files into your IDE
2. Run the `main` method of desired class

## Usage

### AlgorithmVisualizer
- Default runs Bubble Sort
- To switch algorithms, modify the last line in `main()`:
  - `panel.bubbleSort();` - for Bubble Sort
  - `panel.mergeSort();` - for Merge Sort  
  - `panel.quickSort();` - for Quick Sort

### AlgorithmVisualizerv2
- Automatically starts all three algorithms simultaneously
- No user interaction required - just run and watch!

## Customization

### Adjust Array Size
Change the parameter in the constructor call:
```java
AlgorithmVisualizer panel = new AlgorithmVisualizer(100); // 100 elements instead of 50
```

### Modify Animation Speed
Change the sleep duration in the `sleep()` method or thread sleep calls:
```java
Thread.sleep(100); // Slower animation (100ms delay)
Thread.sleep(10);  // Faster animation (10ms delay)
```

### Window Dimensions
Adjust frame size in the `main()` method:
```java
frame.setSize(800, 600); // Width: 800px, Height: 600px
```

## Technical Details

### Data Generation
- Random integers between 10-409 for bar heights
- Same initial dataset across all algorithms for fair comparison

### Visualization Method
- Each array element represented as a vertical bar
- Bar height corresponds to element value
- Real-time repainting during sorting operations

### Threading
- Each sorting algorithm runs in its own thread
- Prevents UI blocking during sorting operations
- Enables simultaneous execution in v2

## Educational Value

Perfect for:
- **Algorithm Learning**: Visual understanding of sorting mechanisms
- **Performance Comparison**: Observe speed differences between algorithms  
- **Complexity Analysis**: See how different approaches handle the same data
- **Computer Science Education**: Demonstrate algorithmic concepts

## License

Open source - feel free to modify and distribute for educational purposes.

## Contributing

Contributions welcome! Consider adding:
- Additional sorting algorithms (Selection Sort, Insertion Sort, Heap Sort)
- User controls (pause/resume, speed adjustment, reset)
- Performance metrics display
- Sound effects
- Different visualization styles
