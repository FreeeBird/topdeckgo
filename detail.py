# -*- coding:UTF-8 -*-
import requests
from bs4 import BeautifulSoup

if __name__ == '__main__':
    server = 'http://db.duowan.com/lushi/card/detail/Huge_Toad.html'
    req = requests.get(url=server)
    req.encoding = 'utf-8'
    html = req.text
    bf = BeautifulSoup(html)
    tb = bf.find_all('table', class_='table-s3 full')
    t_f = BeautifulSoup(str(tb))
    # 图片
    img = t_f.find('img').get('src')
    print(img)
    # 描述
    ms = t_f.find('tr', class_='ms')
    ms_tf = BeautifulSoup(str(ms))
    desc = ms_tf.find_all('td')[1].string
    print(desc)

    body = t_f.find_all('tr')
    body_f = BeautifulSoup(str(body))
    td = body_f.find_all('td')
    i = 2
    inf = []
    while i <= td.__len__():
        inf.append(td[i].string)
        i = i + 2
    print(inf)


