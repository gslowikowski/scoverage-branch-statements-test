import org.junit.Test
import org.junit.Assert.assertEquals

class SimpleIfTest
{
    @Test
    def testSimpleIfWithTrue()
    {
        assertEquals("True", SimpleIf.simpleIf(true))
    }

    @Test
    def testSimpleIfWithFalse()
    {
        assertEquals((), SimpleIf.simpleIf(false))
    }

    @Test
    def testSimpleIfElseWithTrue()
    {
        assertEquals("True", SimpleIf.simpleIfElse(true))
    }

    @Test
    def testSimpleIfElseWithFalse()
    {
        assertEquals("False", SimpleIf.simpleIfElse(false))
    }

}
