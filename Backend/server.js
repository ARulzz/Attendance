var express=require('express');
var app=express();
var bodyParser=require('body-parser');
var morgan=require('morgan');
var mongoose=require('mongoose');
var passport=require('passport');
var config=require('./config/database');
var User=require('./app/models/user');
var port=process.env.PORT || 3000;
var jwt=require('jwt-simple');
var apiRoutes = express.Router();

mongoose.connect(config.database);

require('./config/passport')(passport);

//get params
app.use(bodyParser.urlencoded({extended:false}));
app.use(bodyParser.json());

//console log
 
 app.use(morgan('dev'));

 //use passport
 app.use(passport.initialize());

 //route /
 app.get('/',function(req,res){
      res.send('Welcome to Attendance APP @'+port+ ' @/api');
  });
 
apiRoutes.post('/signup', function(req, res) {
  if (!req.body.name || !req.body.password) {
    res.json({success: false, msg: 'Please pass name and password.'});
  } 
  else {
    var newUser = new User({
      name: req.body.name,
      sex:req.body.sex,
      age:req.body.age,
      address:req.body.addr,
      contact:req.body.phone,
      email:req.body.email,
      password: req.body.password
    });
    // save the user
    newUser.save(function(err) {
      if (err) {
        return res.json({success: false, msg: 'Username already exists.'});
      }
      res.json({success: true, msg: 'Successful created new user.'});
    });
  }
});
var log_token=null;
apiRoutes.post('/login', function(req, res) {
  User.findOne({
    name: req.body.name
  },function(err, user) {
    if (err) throw err;
 
    if (!user) {
      res.send({success: false, msg: 'Authentication failed. User not found.'});
    } 
    else {
      // check if password matches
          user.comparePassword(req.body.password, function (err, isMatch) {
               if (isMatch && !err) {
          // if user is found and password is right create a token
                    var token = jwt.encode(user, config.secret);
                    log_token=token;
          // return the information including token as JSON
                    res.json({success: true, token: 'JWT ' + token,data:user});
               } 
        else {
          res.send({success: false, msg: 'Authentication failed. Wrong password.'});
        }
      });
    }
  });
});
app.use('/api', apiRoutes);

app.listen(port);
console.log('Server up @ port '+port);