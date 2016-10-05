# LibraryManagrment
软工实验2
# 实验要求
使用MySQL建立一个“图书数据库“ BookDB，包含两张表：
– Book {ISBN (PK), Title, AuthorID (FK), Publisher, PublishDate, Price}
– Author {AuthorID (PK), Name, Age, Country}
 手工输入足够多的若干测试数据；
## 功能需求：
– 输入作者名字，查询该作者所著的全部图书的题目；
– 当用户点击某本图书的题目时，展示图书详细信息和作者详细信息；
– 当用户点击“删除”按钮时，将对应行的图书从数据表中删除；
– (选做) 用户可新增一本图书，若该书作者不在库中，还需增加新作者；
– (选做) 用户可更新一本图书的作者、出版社、出版日期、价格。
## 性能需求：
# 页面的美观性
## 主页
页首为一个搜索输入框，可以搜索作者，展示作者相应的图书。旁边为新增图书。
下面展示所有图书信息，每个图书后面有编辑按钮，可以编辑图书的信息。包含删除按钮，可以删除图书
##　数据表
– Book {ISBN (PK), Title, AuthorID (FK), Publisher, PublishDate, Price}
– Author {AuthorID (PK), Name, Age, Country}
