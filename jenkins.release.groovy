def build_app(){
  sh 'docker-compose up -d'
}

def test_app(){
  echo 'release-specific testing here'
}

def down_app(){
  sh 'docker-compose down'
}

def release_app(){
}

return this
