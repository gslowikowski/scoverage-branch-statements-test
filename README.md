# scoverage-branch-statements-test
Scoverage branch statements test

1. Run:

```
mvn clean scoverage:test
```

and check Scoverage statements in `target/scoverage-data/scoverage-coverage` file.

or

2. Run:

```
mvn clean scoverage:report
```

and check:
- Scoverage statements in `target/scoverage-data/scoverage-coverage` file,
- Scoverage report in `target/site/scoverage` directory.
