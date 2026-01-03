# Run-Length Encoding (RLE)
This is a simple Java implementation of **Run-Length Encoding (RLE)**, a basic and widely used form of data compression. It works by replacing consecutive occurrences of the same data value with a count and a single instance of that value.


## What is RLE?

**Run-Length Encoding (RLE)** is a lossless data compression technique. This means that when you compress and then decompress the data, you don't lose any information—the original data is perfectly restored. RLE is most effective for data that contains long sequences of the same character or data value.

**How it works:** Instead of storing each individual data point in a sequence, RLE stores the number of times a value repeats consecutively (the "run") and the value itself.

For example, the string `WWWWWWWWWWWWBWWWWWWWWWWWWBBB` would be encoded as `12W1B12W3B`.

  * **12W**: The character 'W' appears 12 times.
  * **1B**: The character 'B' appears 1 time.
  * **12W**: The character 'W' appears 12 times.
  * **3B**: The character 'B' appears 3 times.

This can be a significant reduction in file size for certain types of data, such as simple graphics, icons, or text with repetitive patterns.

## Code Functionality

The `RunLengthEncoding` class contains a static method `encode` that performs the RLE compression.

### `encode(String input)` Method

  * It checks if the input string is `null` or empty and returns an empty string if it is.
  * A `StringBuilder` is used to efficiently build the output string.
  * The code iterates through the input string, keeping a `count` of consecutive, identical characters.
  * When a character changes, the current `count` and the previous character are appended to the `StringBuilder`. The `count` is then reset to `1`.
  * After the loop finishes, the last run of characters is appended to the `StringBuilder`.

### `main(String[] args)` Method

  * This is the main entry point of the program.
  * It defines an example input string `AAAABBBCCDAA`.
  * It calls the `encode` method to perform the compression.
  * Finally, it prints the original and encoded strings to the console, demonstrating the compression result.

### Example Output

Running the program with the default input `AAAABBBCCDAA` will produce the following output:

```
Orginal: AAAABBBCCDAA
Encoded: 4A3B2C1D2A
```