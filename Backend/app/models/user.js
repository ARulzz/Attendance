var mongoose = require('mongoose');
var bcrypt = require('bcrypt');
var Schema = mongoose.Schema;
var UserSchema=new Schema({
	name:{
		type:String,
		required:true
	},
	sex:{
		type:String,
		required:true
	},
	age:{
		type:Number,
		required:true
	},
	address:{
		type:String,
		required:true
	},
	contact:{
		type:Number,
		required:true,
		unique:true
	},
	email:{
		type:String,
		required:true
	},
	password:{
		type:String,
		required:true
	}
});
UserSchema.pre('save', function (next) {
    var user = this;
    if (this.isModified('password') || this.isNew) {
        bcrypt.genSalt(10, function (err, salt) {
            if (err) {
                return next(err);
            }
            bcrypt.hash(user.password, salt, function (err, hash) {
                if (err) {
                    return next(err);
                }
                user.password = hash;
                next();
            });
        });
    } else {
        return next();
    }
});
UserSchema.methods.comparePassword = function (passw, cb) {
    bcrypt.compare(passw, this.password, function (err, isMatch){
        if (err) {
            return cb(err);
        }
        cb(null,isMatch);
 });
}
module.exports = mongoose.model('User',UserSchema);
