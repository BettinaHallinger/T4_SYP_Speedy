#!/usr/bin/env python3
import sqlite3
import sys
import hashlib

name = sys.argv[1]
pw = sys.argv[2]

dbconnect = sqlite3.connect("user.db")
cursor = dbconnect.cursor()
exists = 1
cursor.execute('SELECT * FROM usr')
for row in cursor:
    if row[1]==name and row[2]==pw:
        print("ok")
        
    elif row[1]==name and row[2]!=pw:
        print("falsches Passwort")
        exists = 1
    else:
        exists = 0
        print("Benutzer nicht vorhanden")

dbconnect.close()