#!/usr/bin/python

# simple functions for controlling a LCD 16x2 Display on the GPIO Pins of the Raspberry Pi
# Falkensteiner Software 2016
# http://www.falkensteiner-software.at
#
# feel free to take this sourcecode and reuse/modify it in your project, but please reference 'Falkensteiner Software' as source
# the origin of this script is: 'http://tutorials-raspberrypi.de/raspberry-pi-lcd-display-16x2-hd44780/'
# I reused it by myself and mofified it to meet my own requirements


import time
import RPi.GPIO as GPIO
import sys
#import commands

if len(sys.argv) != 3:
    print("Error")
    exit()

if (int(sys.argv[1]) < 2 or  int(sys.argv[1]) > 10):
    print("Error - Umschaltgeschwindigkeit muss zwischen 2 und 10 Sekunden betragen")
    exit()

t = int(sys.argv[1])
s = sys.argv[2]

LCD_RS = 14
LCD_E  = 15
LCD_DATA4 = 18
LCD_DATA5 = 23
LCD_DATA6 = 24
LCD_DATA7 = 25

LCD_WIDTH = 8           # characters per line
LCD_LINE_1 = 0x00       # Address of 1. Display line
LCD_LINE_2 = 0xC0       # Address of 2. Display line
LCD_CHR = GPIO.HIGH
LCD_CMD = GPIO.LOW
E_PULSE = 0.0005
E_DELAY = 0.0005

MAXLINES = 10
GPIO.cleanup()
def lcd_send_byte(bits, mode):
        GPIO.output(LCD_RS, mode)
        GPIO.output(LCD_DATA4, GPIO.LOW)
        GPIO.output(LCD_DATA5, GPIO.LOW)
        GPIO.output(LCD_DATA6, GPIO.LOW)
        GPIO.output(LCD_DATA7, GPIO.LOW)
        if bits & 0x10 == 0x10:
          GPIO.output(LCD_DATA4, GPIO.HIGH)
        if bits & 0x20 == 0x20:
          GPIO.output(LCD_DATA5, GPIO.HIGH)
        if bits & 0x40 == 0x40:
          GPIO.output(LCD_DATA6, GPIO.HIGH)
        if bits & 0x80 == 0x80:
          GPIO.output(LCD_DATA7, GPIO.HIGH)
        time.sleep(E_DELAY)
        GPIO.output(LCD_E, GPIO.HIGH)
        time.sleep(E_PULSE)
        GPIO.output(LCD_E, GPIO.LOW)
        time.sleep(E_DELAY)
        GPIO.output(LCD_DATA4, GPIO.LOW)
        GPIO.output(LCD_DATA5, GPIO.LOW)
        GPIO.output(LCD_DATA6, GPIO.LOW)
        GPIO.output(LCD_DATA7, GPIO.LOW)
        if bits&0x01==0x01:
          GPIO.output(LCD_DATA4, GPIO.HIGH)
        if bits&0x02==0x02:
          GPIO.output(LCD_DATA5, GPIO.HIGH)
        if bits&0x04==0x04:
          GPIO.output(LCD_DATA6, GPIO.HIGH)
        if bits&0x08==0x08:
          GPIO.output(LCD_DATA7, GPIO.HIGH)
        time.sleep(E_DELAY)
        GPIO.output(LCD_E, GPIO.HIGH)
        time.sleep(E_PULSE)
        GPIO.output(LCD_E, GPIO.LOW)
        time.sleep(E_DELAY)

def config():
        GPIO.setmode(GPIO.BCM)
        GPIO.setwarnings(False)
        GPIO.setup(LCD_E, GPIO.OUT)
        GPIO.setup(LCD_RS, GPIO.OUT)
        GPIO.setup(LCD_DATA4, GPIO.OUT)
        GPIO.setup(LCD_DATA5, GPIO.OUT)
        GPIO.setup(LCD_DATA6, GPIO.OUT)
        GPIO.setup(LCD_DATA7, GPIO.OUT)

def init():
        lcd_send_byte(0x33, LCD_CMD)
        lcd_send_byte(0x32, LCD_CMD)
        lcd_send_byte(0x28, LCD_CMD)
        lcd_send_byte(0x0C, LCD_CMD)
        lcd_send_byte(0x06, LCD_CMD)
        lcd_send_byte(0x01, LCD_CMD)

def message(message, line=1):
        if line == 1:
                lcd_send_byte(LCD_LINE_1, LCD_CMD)
        else:
                lcd_send_byte(LCD_LINE_2, LCD_CMD)

        message = message.ljust(LCD_WIDTH)
        for i in range(LCD_WIDTH):
          lcd_send_byte(ord(message[i]),LCD_CHR)


if __name__ == '__main__':

        config()

        init()

        #message(commands.getoutput('hostname -I'))
        #time.sleep(5)

        count = 0
        sumLetters = 0
        lineNr = 1
        text = list()
        s1 = ""
        s2 = ""

        for i in s:
            if count < 16:

                count += 1
                sumLetters += 1

                if count <= 8:
                  s1 += i

                elif count > 8 and count <= 16:
                  s2 += i

                if sumLetters == len(s) and lineNr <= MAXLINES:
                  text.append([s1, s2])

            else:
                if lineNr <= MAXLINES:
                  text.append([s1, s2])
                  s1 = i
                  s2 = ""
                  count = 1
                  lineNr += 1
                  sumLetters += 1
                  if sumLetters == len(s):
                    text.append([s1, s2])
                else:
                  break


        while True:
          for i in text:
            message(i[0])
            message(i[1], 2)
            time.sleep(t)

GPIO.cleanup()