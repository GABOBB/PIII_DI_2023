int selec = 2;
int bzzer = 3;
int led1 = 4;
int led2 = 5;
int led3 = 6;
int led4 = 7;
int led5 = 8;
int btt1 = 9;
int btt2 = 10;
int btt3 = 11;

bool hit = false;
bool dir = true;
int pos = 1;

void setup() {
  pinMode(selec,INPUT_PULLUP);

  pinMode(bzzer, OUTPUT);

  pinMode(led1,OUTPUT);
  pinMode(led2,OUTPUT);
  pinMode(led3,OUTPUT);
  pinMode(led4,OUTPUT);
  pinMode(led5,OUTPUT);

  pinMode(btt1,INPUT_PULLUP);
  pinMode(btt2,INPUT_PULLUP);
  pinMode(btt3,INPUT_PULLUP);

  Serial.begin(9600);
  Serial.println("Y arrancamos...");
}

void loop() {
  if(digitalRead(selec) == LOW){
    if(!hit){
      //Serial.println("el switch esta activado");
      if(dir){
        switch(pos){
          case 1:
            digitalWrite(led1,LOW);
            digitalWrite(led2,HIGH);
            pos += 1;
            break;
          case 2:
            digitalWrite(led2,LOW);
            digitalWrite(led3,HIGH);
            pos += 1;
            break;
          case 3:
            digitalWrite(led3,LOW);
            digitalWrite(led4,HIGH);
            pos += 1;
            break;
          case 4:
            digitalWrite(led4,LOW);
            digitalWrite(led5,HIGH);
            pos += 1;
            break;
          case 5:
            dir = false;
            pos += 1;
            break;
          default:
            break;
        }
        
      }else{
        switch(pos){
          case 1:
            dir = true;
            break;
          case 2:
            digitalWrite(led1,HIGH);
            digitalWrite(led2,LOW);
            pos -= 1;
            break;
          case 3:
            digitalWrite(led2,HIGH);
            digitalWrite(led3,LOW);
            pos -= 1;
            break;
          case 4:
            digitalWrite(led3,HIGH);
            digitalWrite(led4,LOW);
            pos -= 1;
            break;
          case 5:
            digitalWrite(led4,HIGH);
            digitalWrite(led5,LOW);
            pos -= 1;
            break;
          default:
            pos -= 1;
            break;
        }
        

      }
      if(digitalRead(btt2) == LOW ){
        if(digitalRead(led3) == HIGH){
          hit = true;
          tone(bzzer,300);
          delay(200);
          tone(bzzer,500);
          delay(200);
          noTone(bzzer);
          Serial.println("cayo el avion");
          
        }else{
          tone(bzzer,500);
          delay(200);
          tone(bzzer,200);
          delay(200);
          noTone(bzzer);
          Serial.println("todavia no cayo el avion");
        }
      }
    }
  }else{
    reset();
    if(digitalRead(btt1)== LOW){
      Serial.println("L");
    }
    if(digitalRead(btt3)== LOW){
      Serial.println("R");
    }
  }
 
  delay(200);
}

void reset(){
  hit = false;
  digitalWrite(led1,LOW);
  digitalWrite(led2,LOW);
  digitalWrite(led3,LOW); 
  digitalWrite(led4,LOW);
  digitalWrite(led5,LOW);
}