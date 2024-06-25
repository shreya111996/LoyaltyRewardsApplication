/***************************************************************************************************
 * BROWSER POLYFILLS
 */

// IE9, IE10, and IE11 requires all of the following polyfills.
// import 'core-js/es6/symbol';
// import 'core-js/es6/object';
// import 'core-js/es6/function';
// import 'core-js/es6/parse-int';
// import 'core-js/es6/parse-float';
// import 'core-js/es6/number';
// import 'core-js/es6/math';
// import 'core-js/es6/string';
// import 'core-js/es6/date';
// import 'core-js/es6/array';
// import 'core-js/es6/regexp';
// import 'core-js/es6/map';
// import 'core-js/es6/set';
// import 'core-js/es6/weak-map';
// import 'core-js/es6/weak-set';
// import 'core-js/es6/typed';
// import 'core-js/es6/reflect';
// import 'core-js/es7/reflect';
// import 'intl'; // Run `npm install --save intl`.

// Add global workaround
(window as any).global = window;

// Zone JS is required by Angular itself.
import 'zone.js';  // Included with Angular CLI.

/***************************************************************************************************
 * APPLICATION IMPORTS
 */
