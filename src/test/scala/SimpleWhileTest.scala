import org.junit.Test
import org.junit.Assert.assertEquals

class SimpleWhileTest
{
    @Test
    def testSimpleWhileCountingFromFive()
    {
        assertEquals((), SimpleWhile.simpleWhile(5))
    }

    @Test
    def testSimpleWhileCountingFromZero()
    {
        assertEquals((), SimpleWhile.simpleWhile(0))
    }

}
