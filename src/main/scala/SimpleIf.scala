object SimpleIf
{
  def simpleIf(b: Boolean) =
    if (b)
      "True"

  def simpleIfElse(b: Boolean) =
    if (b)
      "True"
    else
      "False"
}

/*
[[syntax trees at end of                     typer]] // SimpleIf.scala
package <empty> {
  object SimpleIf extends scala.AnyRef {
    def <init>(): SimpleIf.type = {
      SimpleIf.super.<init>();
      ()
    };
    def simpleIf(b: Boolean): Any = if (b)
      "True"
    else
      ()                                                       <-- generated '()' Literal statement
    def simpleIfElse(b: Boolean): String = if (b)
      "True"
    else
      "False"
  }
}

[[syntax trees at end of scoverage-instrumentation]] // SimpleIf.scala
package <empty> {
  object SimpleIf extends scala.AnyRef {
    def <init>(): SimpleIf.type = {
      SimpleIf.super.<init>();
      ()
    };
    def simpleIf(b: Boolean): Any = if (b)
      {
        scoverage.Invoker.invoked(2, "path-to-scoverage-data");    <-- branch
        {
          scoverage.Invoker.invoked(1, "path-to-scoverage-data");
          "True"                                                   <-- "True" Literal statement
        }
      }
    else
      {
        scoverage.Invoker.invoked(4, "path-to-scoverage-data");    <-- branch
        {
          scoverage.Invoker.invoked(3, "path-to-scoverage-data");  <-- !!!!!
          ()                                                       <-- generated '()' Literal statement, should be ignored by scoverage
        }
      };
    def simpleIfElse(b: Boolean): String = if (b)
      {
        scoverage.Invoker.invoked(6, "path-to-scoverage-data");    <-- branch
        {
          scoverage.Invoker.invoked(5, "path-to-scoverage-data");
          "True"                                                   <-- "True" Literal statement
        }
      }
    else
      {
        scoverage.Invoker.invoked(8, "path-to-scoverage-data");    <-- branch
        {
          scoverage.Invoker.invoked(7, "path-to-scoverage-data");
          "False"                                                  <-- "False" Literal statement
        }
      }
  }
}
 */


/*
 Notes:
 - 'simpleIfElse' method - there are two branches and two statements - it's OK
 - 'simpleIf' method - there are two branches and two statements,
   but should be two branches and only one statement (the second, generated one should be ignored)
 */
