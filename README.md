# JLox Programming Language Interpreter

JLox 是一个用 Java 实现的 Lox 编程语言解释器。Lox 是一种小型的动态编程语言，类似于 JavaScript 和 Lua，支持变量、控制流、函数和闭包等特性。

## 项目结构

```
src/
├── tool/         
│   └── GenerateAst.java    # AST 生成工具
├── AstPrinter.java         # AST 打印器
├── Environment.java        # 环境管理（作用域）
├── Expr.java               # 表达式定义
├── Interpreter.java        # 解释器实现
├── Lox.java                # 主程序入口
├── Parser.java             # 解释器
├── RuntimeError.java       # 运行时错误定义
├── Scanner.java            # 扫描器
├── Stmt.java               # 语句定义
├── Token.java              # Token 定义
└── TokenType.java          # Token 类型定义
```

## 语言特性

Lox 语言支持以下特性：

- 基本数据类型：数字、字符串、布尔值和 nil
- 变量声明和赋值 (`var`)
- 算术运算：`+`, `-`, `*`, `/`
- 比较运算：`==`, `!=`, `<`, `>`, `<=`, `>=`
- 逻辑运算：`and`, `or`, `!`
- 控制流：`if-else` 条件语句和 `while`、`for` 循环
- 函数定义和调用 (`fun`)
- 闭包和词法作用域
- 错误处理和报告

## 使用方法

### 编译项目

```bash
javac src/*.java
```

### 运行脚本文件

```bash
java Lox [script_file]
```

### 进入交互式命令行

```bash
java Lox
```

在交互模式下，可以直接输入 Lox 代码并立即看到执行结果。

## 示例代码

在`test/`目录下你会找一些可以直接运行的Lox源码文件。

## 实现细节

JLox 解释器采用经典的三阶段设计：

1. **词法分析 (Scanner)**: 将源代码转换为 Token 序列
2. **语法分析 (Parser)**: 将 Token 序列解析为抽象语法树 (AST)
3. **解释执行 (Interpreter)**: 遍历 AST 并执行代码

### 抽象语法树 (AST)

使用 ***Visitor 模式*** 来表示和操作抽象语法树。表达式和语句都被建模为 AST 节点，每种节点类型都有对应的访问方法。

### 作用域管理

通过 ***Environment 类*** 实现词法作用域，支持嵌套作用域和变量查找。

## 错误处理

JLox 提供两种类型的错误处理：

- **编译时错误**: 语法错误和词法错误
- **运行时错误**: 执行期间发生的错误，如除零错误或类型错误

错误信息会包含行号和描述，帮助用户定位和修复问题。

## 学习资源

这个项目是学习编程语言实现的绝佳资源，基于 Robert Nystrom 的书籍[《Crafting Interpreters》](http://www.craftinginterpreters.com/)实现。