# -*- coding:UTF-8 -*-
import requests
from bs4 import BeautifulSoup
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
        print(data)
        sql = "INSERT INTO " + self.table + "(name,eng_name,class,rarity,type," \
                                            "spellpower,health,atk,skill,description,img_url)" \
                                            "values('%s','%s','%s','%s','%s','%d','%d','%d','%d','%s','%s')" % \
                                            (data[0],data[1],data[2],data[3],data[4], int(data[5]),int(data[6]), int(data[7]), int(data[8]),data[9],data[10])
        try:
            _int = self.cursor.execute(sql)
            self.conn.commit()
        except:
            self.conn.rollback()
            print("insert failed.")

    def closeMysql(self):
        self.cursor.close()
        self.conn.close()


def __detail__(_server):
    # server = 'http://db.duowan.com/lushi/card/detail/Ethereal_Conjurer.html'
    _root = 'http://db.duowan.com/lushi/'
    req1 = requests.get(url=_server)
    req1.encoding = 'utf-8'
    html1 = req1.text
    req2 = requests.get(url=_root)
    req2.encoding = 'utf-8'
    html2 = req2.text
    if html1 == html2 :
        return
    bf1 = BeautifulSoup(html1)
    tb = bf1.find_all('table', class_='table-s3 full')
    tb_f = BeautifulSoup(str(tb))
    body = tb_f.find_all('tr')
    body_f = BeautifulSoup(str(body))
    tds = body_f.find_all('td')
    i = 2
    inf = []
    while i <= tds.__len__():
        inf.append(tds[i].string)
        i = i + 2
    img = tb_f.find('img').get('src')
    inf.append(img)
    _a = 0
    while _a < inf.__len__():
        if inf[_a] is None:
            inf[_a] = 0
        _a = _a + 1
    mySQLCommand.insertMysql(inf)


if __name__ == '__main__':
    server = 'http://db.duowan.com/lushi/'
    _detail = []  # 卡牌详情
    _target = [
        'http://db.duowan.com/lushi/card/list/eyJwIjoxLCJzb3J0IjoiaWQuZGVzYyJ9.html',
        'http://db.duowan.com/lushi/card/list/eyJwIjoyLCJzb3J0IjoiaWQuZGVzYyJ9.html',
        'http://db.duowan.com/lushi/card/list/eyJwIjozLCJzb3J0IjoiaWQuZGVzYyJ9.html',
        'http://db.duowan.com/lushi/card/list/eyJwIjo0LCJzb3J0IjoiaWQuZGVzYyJ9.html',
        'http://db.duowan.com/lushi/card/list/eyJwIjo1LCJzb3J0IjoiaWQuZGVzYyJ9.html',
        'http://db.duowan.com/lushi/card/list/eyJwIjo2LCJzb3J0IjoiaWQuZGVzYyJ9.html',
        'http://db.duowan.com/lushi/card/list/eyJwIjo3LCJzb3J0IjoiaWQuZGVzYyJ9.html',
        'http://db.duowan.com/lushi/card/list/eyJwIjo4LCJzb3J0IjoiaWQuZGVzYyJ9.html',
        'http://db.duowan.com/lushi/card/list/eyJwIjo5LCJzb3J0IjoiaWQuZGVzYyJ9.html',
        'http://db.duowan.com/lushi/card/list/eyJwIjoxMCwic29ydCI6ImlkLmRlc2MifQ_3__3_.html',
        'http://db.duowan.com/lushi/card/list/eyJwIjoxMSwic29ydCI6ImlkLmRlc2MifQ_3__3_.html',
        'http://db.duowan.com/lushi/card/list/eyJwIjoxMiwic29ydCI6ImlkLmRlc2MifQ_3__3_.html',
        'http://db.duowan.com/lushi/card/list/eyJwIjoxMywic29ydCI6ImlkLmRlc2MifQ_3__3_.html',
        'http://db.duowan.com/lushi/card/list/eyJwIjoxNCwic29ydCI6ImlkLmRlc2MifQ_3__3_.html',
        'http://db.duowan.com/lushi/card/list/eyJwIjoxNSwic29ydCI6ImlkLmRlc2MifQ_3__3_.html'
    ]
    for eo in _target:
        req = requests.get(url=eo)
        req.encoding = 'utf-8'
        html = req.text
        bf = BeautifulSoup(html)
        td = bf.find_all('td', class_='name')
        a_bf = BeautifulSoup(str(td))
        a = a_bf.find_all('a')
        for each in a:
            _detail.append(each.get('href'))
    mySQLCommand = MySQLCommand()
    mySQLCommand.connectMysql()
    for each in _detail:
        __detail__(each)
    mySQLCommand.queryMysql()  # 查询数据
    mySQLCommand.closeMysql()

