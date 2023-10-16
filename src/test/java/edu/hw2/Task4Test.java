package edu.hw2;

import edu.hw2.Task4.CallingHelper;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class Task4Test {
    @Test
    void TestClassCallingFunction() {
        var result = CallingHelper.callingInfo();
        assertThat(result.className()).isEqualTo(Task4Test.class.getName());
        assertThat(result.methodName()).isEqualTo("TestClassCallingFunction");
    }

    @Test
    void TestNestedCallings() {
        var result = new A().a();
        assertThat(result.className()).isEqualTo(C.class.getName());
        assertThat(result.methodName()).isEqualTo("c");
    }
}

class A {
    public CallingHelper.CallingInfo a() {
        return new B().b();
    }
}

class B {
    public CallingHelper.CallingInfo b() {
        return new C().c();
    }
}

class C {
    public CallingHelper.CallingInfo c() {
        return CallingHelper.callingInfo();
    }
}
