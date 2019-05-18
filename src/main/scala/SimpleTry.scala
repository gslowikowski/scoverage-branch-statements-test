object SimpleTry {

  def simpleTryCatchFinally =
    try
    {
      println("foo")
    }
    catch
    {
      case t: Throwable =>
        println("bar")
    }
    finally
    {
      println("baz")
    }

  def simpleTryFinally =
    try
    {
      println("foo")
    }
    finally
    {
      println("baz")
    }
}

/*
[[syntax trees at end of                     typer]] // SimpleTry.scala
package <empty> {
  object SimpleTry extends scala.AnyRef {
    def <init>(): SimpleTry.type = {
      SimpleTry.super.<init>();
      ()
    };
    def simpleTryCatchFinally: Unit = try {
      scala.this.Predef.println("foo")
    } catch {
      case (t @ (_: Throwable)) => scala.this.Predef.println("bar")
    } finally scala.this.Predef.println("baz");
    def simpleTryFinally: Unit = try {
      scala.this.Predef.println("foo")
    } finally scala.this.Predef.println("baz")
  }
}

[[syntax trees at end of scoverage-instrumentation]] // SimpleTry.scala
package <empty> {
  object SimpleTry extends scala.AnyRef {
    def <init>(): SimpleTry.type = {
      SimpleTry.super.<init>();
      ()
    };
    def simpleTryCatchFinally: Unit = try {
      scoverage.Invoker.invoked(2, "path-to-scoverage-data");   <-- branch
      {
        scoverage.Invoker.invoked(1, "path-to-scoverage-data");
        scala.this.Predef.println("foo")                        <-- 'scala.Predef.println' Apply statement
      }
    } catch {
      case (t @ (_: Throwable)) => {
        scoverage.Invoker.invoked(3, "path-to-scoverage-data");
        scala.this.Predef.println("bar")                        <-- 'scala.Predef.println' Apply statement
      }
    } finally {
      scoverage.Invoker.invoked(5, "path-to-scoverage-data");   <-- branch
      {
        scoverage.Invoker.invoked(4, "path-to-scoverage-data");
        scala.this.Predef.println("baz")                        <-- 'scala.Predef.println' Apply statement
      }
    };
    def simpleTryFinally: Unit = try {
      scoverage.Invoker.invoked(7, "path-to-scoverage-data");   <-- branch
      {
        scoverage.Invoker.invoked(6, "path-to-scoverage-data");
        scala.this.Predef.println("foo")                        <-- 'scala.Predef.println' Apply statement
      }
    } finally {
      scoverage.Invoker.invoked(9, "path-to-scoverage-data");   <-- branch
      {
        scoverage.Invoker.invoked(8, "path-to-scoverage-data");
        scala.this.Predef.println("baz")                        <-- 'scala.Predef.println' Apply statement
      }
    }
  }
}
 */


/*
 Notes:
 - 'simpleTryCatchFinally' method - there are two branches and three statements -
   number of statements is OK, both branches will be executed always
 - 'simpleTryFinally' method - there are two branches and two statements,
   number of statements is OK, both branches will be executed always

 Why were branches introduced for try/catch/finally block?
 */
