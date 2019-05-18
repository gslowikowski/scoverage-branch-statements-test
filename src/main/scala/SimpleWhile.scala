object SimpleWhile {

  def simpleWhile(startingValue: Int) = {
    var i: Int = startingValue
    while (i > 0)
    {
      i = i + 1
      i = i - 2
    }
  }
}

/*
[[syntax trees at end of                     typer]] // SimpleWhile.scala
package <empty> {
  object SimpleWhile extends scala.AnyRef {
    def <init>(): SimpleWhile.type = {
      SimpleWhile.super.<init>();
      ()
    };
    def simpleWhile(startingValue: Int): Unit = {
      var i: Int = startingValue;
      while$1(){
        if (i.>(0))
          {
            {
              i = i.+(1);
              i = i.-(2)
            };
            while$1()                                              <-- generated 'while$1()' Apply statement
          }
        else
          ()                                                       <-- generated '()' Literal statement
      }
    }
  }
}

[[syntax trees at end of scoverage-instrumentation]] // SimpleWhile.scala
package <empty> {
  object SimpleWhile extends scala.AnyRef {
    def <init>(): SimpleWhile.type = {
      SimpleWhile.super.<init>();
      ()
    };
    def simpleWhile(startingValue: Int): Unit = {
      var i: Int = startingValue;
      while$1(){
        if ({
          scoverage.Invoker.invoked(1, "path-to-scoverage-data");
          i.>(0)                                                          <-- 'i.>(0)' Apply statement
        })
          {
            scoverage.Invoker.invoked(5, "path-to-scoverage-data");       <-- branch
            {
              {
                i = {
                  scoverage.Invoker.invoked(2, "path-to-scoverage-data");
                  i.+(1)                                                  <-- 'i.+(1)' Apply statement
                };
                i = {
                  scoverage.Invoker.invoked(3, "path-to-scoverage-data");
                  i.-(2)                                                  <-- 'i.-(2)' Apply statement
                }
              };
              {
                scoverage.Invoker.invoked(4, "path-to-scoverage-data");   <-- !!!!!
                while$1()                                                 <-- generated 'while$1()' Apply statement, should be ignored by scoverage
              }
            }
          }
        else
          {
            scoverage.Invoker.invoked(7, "path-to-scoverage-data");       <-- branch
            {
              scoverage.Invoker.invoked(6, "path-to-scoverage-data");     <-- !!!!!
              ()                                                          <-- generated '()' Literal statement, should be ignored by scoverage
            }
          }
      }
    }
  }
}
 */


/*
 Notes:
 - 'simpleWhile' method - there are two branches and five statements,
   but should be two branches and only three statements (the two generated ones should be ignored)
   ignoring '()' Literal statement is simple
   ignoring 'while$1()' Apply statement is not so easy, but doable
 */
