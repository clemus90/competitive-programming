process.stdin.resume();
process.stdin.setEncoding('ascii');

var input_stdin = "";
var input_stdin_array = "";
var input_currentline = 0;

process.stdin.on('data', function (data) {
    input_stdin += data;
});

process.stdin.on('end', function () {
    input_stdin_array = input_stdin.split("\n");
    main();
});

function readLine() {
    return input_stdin_array[input_currentline++];
}

/////////////// ignore above this line ////////////////////

function main() {
    var Q = parseInt(readLine());
    for(var a0 = 0; a0 < Q; a0++){
        var n = parseInt(readLine());
        var b = readLine();

        var chars = totalCharacters(b);
        console.log(chars);
    }

}

function totalCharacters(string) {
    var object = {};
    var result = 'NO';
    var regex = /[A-Z_]/g;
    if(regex.test(string)) {
      if(string.indexOf('_') > -1) {
        for (var i = 0; i < string.length; i++) {
            var character = string.charAt(i);
            if(object[character]) {
                object[character]++;
            } else {
                object[character] = 1;
            }
        }
        for (var prop in object) {
            if (prop === '_' && object[prop] >= 1) {
                result = 'YES';
            }
            if (prop !== '_' && object[prop] > 1) {
                result = 'YES';
            } else if (prop !== '_') {
                result = 'NO';
                break;
            }
        }
      } else {
        result = 'YES';
        for (var i = 0; i < string.length; i++) {
          var isHappy = false;
          if (i>0 && string[i-1]==string[i]) {
              isHappy = true;
          }
          if (i<string.length-1 && string[i+1]==string[i]) {
              isHappy = true;
          }
          if (!isHappy) {
              result = 'NO';
              break;
          }

        }
      }
    }
    return result;
}
