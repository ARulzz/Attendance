var JwtStrategy = require('passport-jwt').Strategy;
var User = require('../app/models/user');
var config = require('../config/database'); // get db config file
var ExtractJwt = require('passport-jwt').ExtractJwt;

module.exports = function(passport) {
  var opts = {};
  opts.secretOrKey = config.secret;
  opts.jwtFromRequest = ExtractJwt.fromAuthHeader();
  passport.use(new JwtStrategy(opts, function(jwt_payload, done) {
    User.findOne({id: jwt_payload.id}, function(err, user) {
          if (err) {
              return done(err, false);
          }
          if (user) {
              done(null, user);
          } else {
              done(null, false);
          }
      });
  }));
};