package edu.hw2;

import org.junit.jupiter.api.Test;
import edu.hw2.TaskFour.CallingHelper;
import static org.assertj.core.api.Assertions.assertThat;

public class TaskFourTest {
    @Test
    void TestClassCallingFunction() {
        var result = CallingHelper.callingInfo();
        assertThat(result.className()).isEqualTo("edu.hw2.TaskFourTest");
        assertThat(result.methodName()).isEqualTo("TestClassCallingFunction");
    }

    @Test
    void TestNestedCallings() {
        var result = new A().A();
        assertThat(result.className()).isEqualTo("edu.hw2.C");
        assertThat(result.methodName()).isEqualTo("C");
    }
}

class A {
    public CallingHelper.CallingInfo A() {
        return new B().B();
    }
}

class B {
    public CallingHelper.CallingInfo B() {
        return new C().C();
    }
}

class C {
    public CallingHelper.CallingInfo C() {
        return CallingHelper.callingInfo();
    }
}
