def build_app(){
  sh 'docker-compose up -d'
}

def test_app(){
  sh 'python test_app.py'
}

def down_app(){
  sh 'docker-compose down'
}

def release_app(){
  echo 'branch into release'
}

dev live_app(){
}

return this
