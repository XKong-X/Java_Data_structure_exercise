package stackdemo;

/**
 * ClassName: IStack
 * Package: stackdemo
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/3/27 19:57
 * @Version 1.0
 */
public interface IStack {
    void push(int x);

    int pop();

    int peek();

    int size();

    boolean empty();

    boolean full();
}
