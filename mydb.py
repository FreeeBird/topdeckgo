# -*- coding: utf-8 -*-

import pymysql


# 用来操作数据库的类
class MySQLCommand(object):
    # 类的初始化
    def __init__(self):
        self.host = 'localhost'
        self.port = 3306  # 端口号
        self.user = 'root'  # 用户名
        self.password = "root"  # 密码
        self.db = "topdeck"  # 库
        self.table = "t_cards"  # 表

    # 链接数据库
    def connectMysql(self):
        try:
            self.conn = pymysql.connect(host=self.host, port=self.port, user=self.user,
                                        passwd=self.password, db=self.db, charset='utf8')
            self.cursor = self.conn.cursor()
        except:
            print('connect mysql error.')

    # 查询数据
    def queryMysql(self):
        sql = "SELECT * FROM " + self.table

        try:
            self.cursor.execute(sql)
            row = self.cursor.fetchone()
            print(row)

        except:
            print(sql + ' execute failed.')

    # 插入数据
    def insertMysql(self, data):
        sql = "INSERT INTO " + self.table + " VALUES(" + data[0] + "," + "'" + data[1] + "'," + "'" + data[2] + "')"
        try:
            self.cursor.execute(sql)
        except:
            print("insert failed.")

    # 更新数据
    def updateMysqlSN(self, name, sex):
        sql = "UPDATE " + self.table + " SET sex='" + sex + "'" + " WHERE name='" + name + "'"
        print("update sn:" + sql)

        try:
            self.cursor.execute(sql)
            self.conn.commit()
        except:
            self.conn.rollback()

    def closeMysql(self):
        self.cursor.close()
        self.conn.close()


# 创建数据库操作类的实例
mySQLCommand = MySQLCommand()
mySQLCommand.connectMysql()
mySQLCommand.queryMysql()#查询数据

