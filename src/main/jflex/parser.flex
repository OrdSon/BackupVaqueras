package gt.edu.usac.compiler;
import java_cup.runtime.*;
import java.util.LinkedList;


%%
%public
%class MyLexer
%cup
%line
%column
%caseless
%state STRING
%state COMMENT
%state LINECOMMENT


Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}
TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" {cualquierCaracter}* {finDeLinea}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*
digit = [0-9]
letter = [a-zA-Z]
cualquierCaracter = [^\r\n]
finDeLinea = \r|\n|\r\n
whitespace = {finDeLinea}|[ \t\f]
identifier = ({letter}|"_")+({letter}|{digit}|"-"|"_")*
INTEGER = "int"
LONG = "long" 
FLOAT = "float"
DOUBLE = "double"
DECIMAL = "decimal"
STRING = "string"
CHAR = "char"
BOOL = "bool"
VOID = "void"
ASIGN = "="
FOR = "for"

%{
    LinkedList<String> errores = new LinkedList<>();
    StringBuffer string = new StringBuffer();

    public LinkedList<String> getErrores(){
        return errores;
    }
    
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);    
    }
    
    private Symbol symbol(int type,int line, int column, Object value){
        return new Symbol (type,line, column,value);    
    }

    private String getChar(String cadena){
        return cadena.replace("'","");
    }
%}

%eofval{
    return symbol(MyParserSym.EOF);
%eofval}

%%
<YYINITIAL>{

\"              {string.setLength(0);yybegin(STRING);}
"\""            {string.setLength(0);yybegin(STRING);}
"/*"            {string.setLength(0);yybegin(COMMENT);}
}

<STRING> {
      \"                             { yybegin(YYINITIAL);
                                       return new Symbol(MyParserSym.stringValue,string.toString());}
    "\""                            { yybegin(YYINITIAL);
                                       return new Symbol(MyParserSym.stringValue,string.toString());}
      [^\n\r\"\\]+                   { string.append(yytext()); }
      \\t                            { string.append('\t'); }
      \\n                            { string.append('\n'); }
      \\f                            { string.append('\f'); }
      \\r                            { string.append('\r'); }
      \\\"                           { string.append('\"'); }
      \\                             { string.append('\\'); }
      \\0                            {yybegin(YYINITIAL);
                                        return new Symbol(MyParserSym.ERROR,"Contiene caracter nulo");}//ERROR de caracter nulo
      
      {finDeLinea}                           {yybegin(YYINITIAL);
                                       return new Symbol(MyParserSym.ERROR,"UNTERMINATED STRING CONSTANT");}
}



{digit}+"."{digit}+  {return symbol(MyParserSym.doubleValue, yyline,yycolumn,Double.valueOf(yytext()));}
{digit}+  {return symbol(MyParserSym.intValue,yyline,yycolumn, Double.valueOf(yytext()));}
"."   {return  symbol(MyParserSym.DOT,yyline,yycolumn,yytext());}
"{"   {return  symbol(MyParserSym.LBRACE,yyline,yycolumn,yytext());}
"}"   {return symbol(MyParserSym.RBRACE,yyline,yycolumn,yytext());}
","   {return symbol(MyParserSym.COMMA,yyline,yycolumn,yytext());}
"("         {return symbol(MyParserSym.LPAREN,yyline,yycolumn,yytext());}
")"         {return symbol(MyParserSym.RPAREN,yyline,yycolumn,yytext());}
"+"         {return symbol(MyParserSym.PLUS,yyline,yycolumn,yytext());}
"*"         {return symbol(MyParserSym.TIMES,yyline,yycolumn,yytext());}
"%"         {return symbol(MyParserSym.MOD,yyline,yycolumn,yytext());}
"/"         {return symbol(MyParserSym.DIV,yyline,yycolumn,yytext());}
":"     {return symbol(MyParserSym.COLON,yyline,yycolumn,yytext());}
"-"         {return symbol(MyParserSym.MINUS,yyline,yycolumn,yytext());}
";"   {return symbol(MyParserSym.SEMI,yyline,yycolumn,yytext());}
"<" {return symbol(MyParserSym.LT,yyline,yycolumn,yytext());}
">" {return symbol(MyParserSym.GT,yyline,yycolumn,yytext());}
"<=" {return symbol(MyParserSym.LET,yyline,yycolumn,yytext());}
">=" {return symbol(MyParserSym.LGT,yyline,yycolumn,yytext());}
"&" {return symbol(MyParserSym.AND,yyline,yycolumn,yytext());}
"|" {return symbol(MyParserSym.OR,yyline,yycolumn,yytext());}
"!" {return symbol(MyParserSym.NOT,yyline,yycolumn,yytext());}
"int"         {return symbol(MyParserSym.INT,yyline,yycolumn,yytext());}
"while"     {return symbol(MyParserSym.WHILE,yyline,yycolumn,yytext());}
"true"      {return symbol(MyParserSym.TRUE,yyline,yycolumn,yytext());}
"false"     {return symbol(MyParserSym.FALSE,yyline,yycolumn,yytext());}
"do"     {return symbol(MyParserSym.DO,yyline,yycolumn,yytext());}
"if"     {return symbol(MyParserSym.IF,yyline,yycolumn,yytext());}
"else"     {return symbol(MyParserSym.ELSE,yyline,yycolumn,yytext());}
"continue"     {return symbol(MyParserSym.CONTINUE,yyline,yycolumn,yytext());}
"break"     {return symbol(MyParserSym.BREAK,yyline,yycolumn,yytext());}
"return"     {return symbol(MyParserSym.RETURN,yyline,yycolumn,yytext());}
"main"  {return symbol(MyParserSym.MAIN,yyline,yycolumn,yytext());}
"switch" {return symbol(MyParserSym.SWITCH,yyline,yycolumn,yytext());}
"default" {return symbol(MyParserSym.DEFAULT,yyline,yycolumn,yytext());}
"case" {return symbol(MyParserSym.CASE,yyline,yycolumn,yytext());}
"Console" {return symbol(MyParserSym.CONSOLE,yyline,yycolumn,yytext());}
"Write" {return symbol(MyParserSym.WRITE,yyline,yycolumn,yytext());}
"WRITELINE" {return symbol(MyParserSym.WRITELINE,yyline,yycolumn,yytext());}
{FOR} {return symbol(MyParserSym.FOR,yyline,yycolumn,yytext());}
{ASIGN} {return symbol(MyParserSym.ASIGN,yyline,yycolumn,yytext());}
{INTEGER} {return  symbol(MyParserSym.INT,yyline,yycolumn,yytext());}
{LONG} {return symbol (MyParserSym.LONG,yyline,yycolumn,yytext());}
{FLOAT} {return symbol (MyParserSym.FLOAT,yyline,yycolumn,yytext());}
{DOUBLE} {return symbol (MyParserSym.DOUBLE,yyline,yycolumn,yytext());}
{DECIMAL} {return symbol (MyParserSym.DECIMAL,yyline,yycolumn,yytext());}
{STRING} {return symbol (MyParserSym.STRING,yyline,yycolumn,yytext());}
{CHAR} {return symbol (MyParserSym.CHAR,yyline,yycolumn,yytext());}
{BOOL} {return symbol (MyParserSym.BOOL,yyline,yycolumn,yytext());}
{VOID} {return  symbol(MyParserSym.VOID,yyline,yycolumn,yytext());}


"'"[^]"'" {return symbol(MyParserSym.charValue,yyline,yycolumn,getChar(yytext()));}
{identifier} {return symbol (MyParserSym.identifier,yyline,yycolumn,yytext());}

{whitespace}+ {/*nadita*/}
{Comment} {/*NADA DE NADA*/}
[^]         {String mensaje = "cadena ilegal::= "+yytext()+" en posicion: "+(yyline+1)+", "+(yycolumn+1);
            errores.add(mensaje);
            return symbol (MyParserSym.ERROR,yyline,yycolumn,yytext());}