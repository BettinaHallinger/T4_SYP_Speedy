import RPi.GPIO as GPIO
import time
import datetime
import sys

#check if there are only six arguments (name of file, motor speed, start time [h], start time [min], end time [h], end time [min])
if len(sys.argv) != 6:
    print("Wrong number of arguments")
    exit()

#check if number of speed is correct
if (int(sys.argv[1]) < 0 or  int(sys.argv[1]) > 100):
    print("Your Number is not between 1 and 100")
    exit()

speed = int(sys.argv[1])

START = datetime.time((int(sys.argv[2])), (int(sys.argv[3])))
END = datetime.time((int(sys.argv[4])), (int(sys.argv[5])))

jetzt =  datetime.datetime.now().time()
print("Start: ", START, "Jetzt: ", jetzt, "  Ende: ", END)
    

if jetzt < START or jetzt > END:
    print("false")

else:
    MOTOR_GPIO = 21
    GPIO.setmode (GPIO.BCM)

    GPIO.setup (MOTOR_GPIO, GPIO.OUT)

    pwmMotor = GPIO.PWM(MOTOR_GPIO, 100)

    pwmMotor.start(0)
    try:

        pwmMotor.ChangeDutyCycle(speed)
        while 1:
            jetzt = datetime.datetime.now().time()
            
            if jetzt > END:
                pwmMotor.stop()
                break

    except KeyboardInterrupt:
        pass

    pwmMotor.stop()



    GPIO.output (MOTOR_GPIO, GPIO.HIGH)

GPIO.output(MOTOR_GPIO, GPIO.LOW)

GPIO.cleanup()