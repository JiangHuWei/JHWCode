/*
 * @Author: TAO
 * @Date:   2017-11-07 16:22:42
 * @Last Modified by:   TAO
 * @Last Modified time: 2017-11-07 16:22:44
 */
! function(e, t) {
	"object" == typeof exports && "object" == typeof module ? module.exports = t() : "function" == typeof define && define.amd ? define([], t) : "object" == typeof exports ? exports.ImgResize = t() : e.ImgResize = t()
}(this, function() {
	return function(e) {
		function t(r) {
			if(n[r]) return n[r].exports;
			var o = n[r] = {
				exports: {},
				id: r,
				loaded: !1
			};
			return e[r].call(o.exports, o, o.exports, t), o.loaded = !0, o.exports
		}
		var n = {};
		return t.m = e, t.c = n, t.p = "", t(0)
	}([function(e, t, n) {
		"use strict";

		function r(e) {
			return e && e.__esModule ? e : {
				default: e
			}
		}
		Object.defineProperty(t, "__esModule", {
			value: !0
		});
		var o = n(1),
			i = r(o);
		t.default = i.default
	}, function(e, t, n) {
		"use strict";

		function r(e) {
			return e && e.__esModule ? e : {
				default: e
			}
		}
		Object.defineProperty(t, "__esModule", {
			value: !0
		});
		var o = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function(e) {
				return typeof e
			} : function(e) {
				return e && "function" == typeof Symbol && e.constructor === Symbol && e !== Symbol.prototype ? "symbol" : typeof e
			},
			i = n(2),
			a = n(3),
			s = r(a);
		! function(e) {
			function t(e, t) {
				this.file = e, this.options = r.extend({}, a, t), this._defaults = a, this._name = n, this.init()
			}
			var n = "canvasResize",
				r = {
					newsize: function(e, t, n, r, o) {
						var i = o ? "h" : "";
						var _scale = t/e*1;
						
						if(n && e > n || r && t > r) {
							var a = e / t;
							(a >= 1 || 0 === r) && n && !o ? (e = n, t = n / a >> 0) : o && a <= n / r ? (e = n, t = n / a >> 0, i = "w") : (e = r * a >> 0, t = r)
						}
						return {						
							width: 1080,
							height: 1080*_scale,
							cropped: i
						}
						console.log(e)
					},
					dataURLtoBlob: function(e) {
						for(var t = e.split(",")[0].split(":")[1].split(";")[0], n = atob(e.split(",")[1]), r = new ArrayBuffer(n.length), o = new Uint8Array(r), i = 0; i < n.length; i++) o[i] = n.charCodeAt(i);
						var a = window.BlobBuilder || window.WebKitBlobBuilder || window.MozBlobBuilder;
						return a ? (a = new(window.BlobBuilder || window.WebKitBlobBuilder || window.MozBlobBuilder), a.append(r), a.getBlob(t)) : a = new Blob([r], {
							type: t
						})
					},
					detectSubsampling: function(e) {
						var t = e.width,
							n = e.height;
						if(t * n > 1048576) {
							var r = document.createElement("canvas");
							r.width = r.height = 1;
							var o = r.getContext("2d");
							return o.drawImage(e, -t + 1, 0), 0 === o.getImageData(0, 0, 1, 1).data[3]
						}
						return !1
					},
					rotate: function(e, t) {
						var n = {
							1: {
								90: 6,
								180: 3,
								270: 8
							},
							2: {
								90: 7,
								180: 4,
								270: 5
							},
							3: {
								90: 8,
								180: 1,
								270: 6
							},
							4: {
								90: 5,
								180: 2,
								270: 7
							},
							5: {
								90: 2,
								180: 7,
								270: 4
							},
							6: {
								90: 3,
								180: 8,
								270: 1
							},
							7: {
								90: 4,
								180: 5,
								270: 2
							},
							8: {
								90: 1,
								180: 6,
								270: 3
							}
						};
						return n[e][t] ? n[e][t] : e
					},
					transformCoordinate: function(e, t, n, r) {
						switch(r) {
							case 5:
							case 6:
							case 7:
							case 8:
								e.width = n, e.height = t;
								break;
							default:
								e.width = t, e.height = n
						}
						var o = e.getContext("2d");
						switch(r) {
							case 1:
								break;
							case 2:
								o.translate(t, 0), o.scale(-1, 1);
								break;
							case 3:
								o.translate(t, n), o.rotate(Math.PI);
								break;
							case 4:
								o.translate(0, n), o.scale(1, -1);
								break;
							case 5:
								o.rotate(.5 * Math.PI), o.scale(1, -1);
								break;
							case 6:
								o.rotate(.5 * Math.PI), o.translate(0, -n);
								break;
							case 7:
								o.rotate(.5 * Math.PI), o.translate(t, -n), o.scale(-1, 1);
								break;
							case 8:
								o.rotate(-.5 * Math.PI), o.translate(-t, 0)
						}
					},
					detectVerticalSquash: function(e, t, n) {
						var r = document.createElement("canvas");
						r.width = 1, r.height = n;
						var o = r.getContext("2d");
						o.drawImage(e, 0, 0);
						for(var i = o.getImageData(0, 0, 1, n).data, a = 0, s = n, u = n; u > a;) {
							var c = i[4 * (u - 1) + 3];
							0 === c ? s = u : a = u, u = s + a >> 1
						}
						var d = u / n;
						return 0 === d ? 1 : d
					},
					callback: function(e) {
						return e
					},
					extend: function() {
						var e = arguments[0] || {},
							t = 1,
							n = arguments.length,
							i = !1;
						e.constructor === Boolean && (i = e, e = arguments[1] || {}), 1 === n && (e = this, t = 0);
						for(var a; t < n; t++)
							if(null !== (a = arguments[t]))
								for(var s in a) e !== a[s] && (i && "object" === o(a[s]) && e[s] ? r.extend(e[s], a[s]) : void 0 !== a[s] && (e[s] = a[s]));
						return e
					}
				},
				a = {
					crop: !1,
					quality: 1,
					rotate: 0,
					maxSize: 102400,
					callback: r.callback
				};
			t.prototype = {
				init: function() {
					var e = this,
						t = this.file,
						n = this.options.maxSize,
						o = this.options.quality,
						a = new FileReader;
					a.onloadend = function(t) {
						var a = t.target.result,
							u = atob(a.split(",")[1]),
							c = new i.BinaryFile(u, 0, u.length),
							d = s.default.readFromBinaryFile(c),
							l = new Image;
						l.onload = function(t) {
							var i = d.Orientation || 1;
							i = r.rotate(i, e.options.rotate);
							var s = i >= 5 && i <= 8 ? r.newsize(l.height, l.width, e.options.width, e.options.height, e.options.crop) : r.newsize(l.width, l.height, e.options.width, e.options.height, e.options.crop),
								u = l.width,
								c = l.height,
								g = s.width,
								f = s.height,
								h = document.createElement("canvas"),
								p = h.getContext("2d");
							p.save(), r.transformCoordinate(h, g, f, i), r.detectSubsampling(l) && (u /= 2, c /= 2);
							var m = 1024,
								S = document.createElement("canvas");
							S.width = S.height = m;
							for(var y = S.getContext("2d"), A = r.detectVerticalSquash(l, u, c), w = 0; w < c;) {
								for(var v = w + m > c ? c - w : m, B = 0; B < u;) {
									var b = B + m > u ? u - B : m;
									y.clearRect(0, 0, m, m), y.drawImage(l, -B, -w);
									var P = Math.floor(B * g / u),
										F = Math.ceil(b * g / u),
										C = Math.floor(w * f / c / A),
										D = Math.ceil(v * f / c / A);
									p.drawImage(S, 0, 0, b, v, P, C, F, D), B += m
								}
								w += m
							}
							p.restore(), S = y = null;
							var I = document.createElement("canvas");
							I.width = "h" === s.cropped ? f : g, I.height = "w" === s.cropped ? g : f;
							var x, L = "h" === s.cropped ? .5 * (f - g) : 0,
								R = "w" === s.cropped ? .5 * (g - f) : 0;
							x = I.getContext("2d"), x.drawImage(h, L, R, g, f);
							var M = a.length > n ? I.toDataURL("image/jpeg", o) : a;
							e.options.callback(M, I.width, I.height)
						}, l.src = a
					}, a.readAsDataURL(t)
				}
			}, window.canvasResize = function(e, n) {
				return "string" == typeof e ? r[e](n) : void new t(e, n)
			}
		}(window), t.default = {
			canvasResize: canvasResize
		}
	}, function(e, t) {
		"use strict";
		Object.defineProperty(t, "__esModule", {
			value: !0
		});
		var n = function(e, t, n) {
				var r = e,
					o = t || 0,
					i = 0;
				this.getRawData = function() {
					return r
				}, "string" == typeof e ? (i = n || r.length, this.getByteAt = function(e) {
					return 255 & r.charCodeAt(e + o)
				}, this.getBytesAt = function(e, t) {
					for(var n = [], i = 0; i < t; i++) n[i] = 255 & r.charCodeAt(e + i + o);
					return n
				}) : "unknown" == typeof e && (i = n || IEBinary_getLength(r), this.getByteAt = function(e) {
					return IEBinary_getByteAt(r, e + o)
				}, this.getBytesAt = function(e, t) {
					return new VBArray(IEBinary_getBytesAt(r, e + o, t)).toArray()
				}), this.getLength = function() {
					return i
				}, this.getSByteAt = function(e) {
					var t = this.getByteAt(e);
					return t > 127 ? t - 256 : t
				}, this.getShortAt = function(e, t) {
					var n = t ? (this.getByteAt(e) << 8) + this.getByteAt(e + 1) : (this.getByteAt(e + 1) << 8) + this.getByteAt(e);
					return n < 0 && (n += 65536), n
				}, this.getSShortAt = function(e, t) {
					var n = this.getShortAt(e, t);
					return n > 32767 ? n - 65536 : n
				}, this.getLongAt = function(e, t) {
					var n = this.getByteAt(e),
						r = this.getByteAt(e + 1),
						o = this.getByteAt(e + 2),
						i = this.getByteAt(e + 3),
						a = t ? (((n << 8) + r << 8) + o << 8) + i : (((i << 8) + o << 8) + r << 8) + n;
					return a < 0 && (a += 4294967296), a
				}, this.getSLongAt = function(e, t) {
					var n = this.getLongAt(e, t);
					return n > 2147483647 ? n - 4294967296 : n
				}, this.getStringAt = function(e, t) {
					for(var n = [], r = this.getBytesAt(e, t), o = 0; o < t; o++) n[o] = String.fromCharCode(r[o]);
					return n.join("")
				}, this.getCharAt = function(e) {
					return String.fromCharCode(this.getByteAt(e))
				}, this.toBase64 = function() {
					return window.btoa(r)
				}, this.fromBase64 = function(e) {
					r = window.atob(e)
				}
			},
			r = function() {
				function e() {
					var e = null;
					return window.ActiveXObject ? e = new ActiveXObject("Microsoft.XMLHTTP") : window.XMLHttpRequest && (e = new XMLHttpRequest), e
				}

				function t(t, n, r) {
					var o = e();
					o ? (n && ("undefined" != typeof o.onload ? o.onload = function() {
						"200" == o.status ? n(this) : r && r(), o = null
					} : o.onreadystatechange = function() {
						4 == o.readyState && ("200" == o.status ? n(this) : r && r(), o = null)
					}), o.open("HEAD", t, !0), o.send(null)) : r && r()
				}

				function r(t, r, o, i, a, s) {
					var u = e();
					if(u) {
						var c = 0;
						i && !a && (c = i[0]);
						var d = 0;
						i && (d = i[1] - i[0] + 1), r && ("undefined" != typeof u.onload ? u.onload = function() {
							"200" == u.status || "206" == u.status || "0" == u.status ? (u.binaryResponse = new n(u.responseText, c, d), u.fileSize = s || u.getResponseHeader("Content-Length"), r(u)) : o && o(), u = null
						} : u.onreadystatechange = function() {
							if(4 == u.readyState) {
								if("200" == u.status || "206" == u.status || "0" == u.status) {
									var e = {
										status: u.status,
										binaryResponse: new n("unknown" == typeof u.responseBody ? u.responseBody : u.responseText, c, d),
										fileSize: s || u.getResponseHeader("Content-Length")
									};
									r(e)
								} else o && o();
								u = null
							}
						}), u.open("GET", t, !0), u.overrideMimeType && u.overrideMimeType("text/plain; charset=x-user-defined"), i && a && u.setRequestHeader("Range", "bytes=" + i[0] + "-" + i[1]), u.setRequestHeader("If-Modified-Since", "Sat, 1 Jan 1970 00:00:00 GMT"), u.send(null)
					} else o && o()
				}
				return function(e, n, o, i) {
					i ? t(e, function(t) {
						var a, s, u = parseInt(t.getResponseHeader("Content-Length"), 10),
							c = t.getResponseHeader("Accept-Ranges");
						a = i[0], i[0] < 0 && (a += u), s = a + i[1] - 1, r(e, n, o, [a, s], "bytes" == c, u)
					}) : r(e, n, o)
				}
			}();
		document.write("<script type='text/vbscript'>\r\nFunction IEBinary_getByteAt(strBinary, iOffset)\r\n\tIEBinary_getByteAt = AscB(MidB(strBinary, iOffset + 1, 1))\r\nEnd Function\r\nFunction IEBinary_getBytesAt(strBinary, iOffset, iLength)\r\n  Dim aBytes()\r\n  ReDim aBytes(iLength - 1)\r\n  For i = 0 To iLength - 1\r\n   aBytes(i) = IEBinary_getByteAt(strBinary, iOffset + i)\r\n  Next\r\n  IEBinary_getBytesAt = aBytes\r\nEnd Function\r\nFunction IEBinary_getLength(strBinary)\r\n\tIEBinary_getLength = LenB(strBinary)\r\nEnd Function\r\n</script>\r\n"), t.BinaryFile = n, t.BinaryAjax = r
	}, function(e, t, n) {
		"use strict";
		Object.defineProperty(t, "__esModule", {
			value: !0
		});
		var r = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function(e) {
				return typeof e
			} : function(e) {
				return e && "function" == typeof Symbol && e.constructor === Symbol && e !== Symbol.prototype ? "symbol" : typeof e
			},
			o = n(2);
		! function(e) {
			e.EXIF = function() {
				function e(e) {
					return !!e.exifdata
				}

				function t(e, t) {
					(0, o.BinaryAjax)(e.src, function(r) {
						var o = n(r.binaryResponse);
						e.exifdata = o || {}, t && t.call(e)
					})
				}

				function n(e) {
					if(255 != e.getByteAt(0) || 216 != e.getByteAt(1)) return !1;
					for(var t, n = 2, r = e.getLength(); n < r;) {
						if(255 != e.getByteAt(n)) return f && console.log("Not a valid marker at offset " + n + ", found: " + e.getByteAt(n)), !1;
						if(t = e.getByteAt(n + 1), 22400 == t) return f && console.log("Found 0xFFE1 marker"), s(e, n + 4, e.getShortAt(n + 2, !0) - 2);
						if(225 == t) return f && console.log("Found 0xFFE1 marker"), s(e, n + 4, e.getShortAt(n + 2, !0) - 2);
						n += 2 + e.getShortAt(n + 2, !0)
					}
				}

				function i(e, t, n, r, o) {
					var i, s, u, c = e.getShortAt(n, o),
						d = {};
					for(u = 0; u < c; u++) i = n + 12 * u + 2, s = r[e.getShortAt(i, o)], !s && f && console.log("Unknown tag: " + e.getShortAt(i, o)), d[s] = a(e, i, t, n, o);
					return d
				}

				function a(e, t, n, r, o) {
					var i, a, s, u, c, d, l = e.getShortAt(t + 2, o),
						g = e.getLongAt(t + 4, o),
						f = e.getLongAt(t + 8, o) + n;
					switch(l) {
						case 1:
						case 7:
							if(1 == g) return e.getByteAt(t + 8, o);
							for(i = g > 4 ? f : t + 8, a = [], u = 0; u < g; u++) a[u] = e.getByteAt(i + u);
							return a;
						case 2:
							return i = g > 4 ? f : t + 8, e.getStringAt(i, g - 1);
						case 3:
							if(1 == g) return e.getShortAt(t + 8, o);
							for(i = g > 2 ? f : t + 8, a = [], u = 0; u < g; u++) a[u] = e.getShortAt(i + 2 * u, o);
							return a;
						case 4:
							if(1 == g) return e.getLongAt(t + 8, o);
							a = [];
							for(var u = 0; u < g; u++) a[u] = e.getLongAt(f + 4 * u, o);
							return a;
						case 5:
							if(1 == g) return c = e.getLongAt(f, o), d = e.getLongAt(f + 4, o), s = new Number(c / d), s.numerator = c, s.denominator = d, s;
							for(a = [], u = 0; u < g; u++) c = e.getLongAt(f + 8 * u, o), d = e.getLongAt(f + 4 + 8 * u, o), a[u] = new Number(c / d), a[u].numerator = c, a[u].denominator = d;
							return a;
						case 9:
							if(1 == g) return e.getSLongAt(t + 8, o);
							for(a = [], u = 0; u < g; u++) a[u] = e.getSLongAt(f + 4 * u, o);
							return a;
						case 10:
							if(1 == g) return e.getSLongAt(f, o) / e.getSLongAt(f + 4, o);
							for(a = [], u = 0; u < g; u++) a[u] = e.getSLongAt(f + 8 * u, o) / e.getSLongAt(f + 4 + 8 * u, o);
							return a
					}
				}

				function s(e, t) {
					if("Exif" != e.getStringAt(t, 4)) return f && console.log("Not valid EXIF data! " + e.getStringAt(t, 4)), !1;
					var n, r, o, a, s, u = t + 6;
					if(18761 == e.getShortAt(u)) n = !1;
					else {
						if(19789 != e.getShortAt(u)) return f && console.log("Not valid TIFF data! (no 0x4949 or 0x4D4D)"), !1;
						n = !0
					}
					if(42 != e.getShortAt(u + 2, n)) return f && console.log("Not valid TIFF data! (no 0x002A)"), !1;
					if(8 != e.getLongAt(u + 4, n)) return f && console.log("Not valid TIFF data! (First offset not 8)", e.getShortAt(u + 4, n)), !1;
					if(r = i(e, u, u + 8, p, n), r.ExifIFDPointer) {
						a = i(e, u, u + r.ExifIFDPointer, h, n);
						for(o in a) {
							switch(o) {
								case "LightSource":
								case "Flash":
								case "MeteringMode":
								case "ExposureProgram":
								case "SensingMethod":
								case "SceneCaptureType":
								case "SceneType":
								case "CustomRendered":
								case "WhiteBalance":
								case "GainControl":
								case "Contrast":
								case "Saturation":
								case "Sharpness":
								case "SubjectDistanceRange":
								case "FileSource":
									a[o] = S[o][a[o]];
									break;
								case "ExifVersion":
								case "FlashpixVersion":
									a[o] = String.fromCharCode(a[o][0], a[o][1], a[o][2], a[o][3]);
									break;
								case "ComponentsConfiguration":
									a[o] = S.Components[a[o][0]] + S.Components[a[o][1]] + S.Components[a[o][2]] + S.Components[a[o][3]]
							}
							r[o] = a[o]
						}
					}
					if(r.GPSInfoIFDPointer) {
						s = i(e, u, u + r.GPSInfoIFDPointer, m, n);
						for(o in s) {
							switch(o) {
								case "GPSVersionID":
									s[o] = s[o][0] + "." + s[o][1] + "." + s[o][2] + "." + s[o][3]
							}
							r[o] = s[o]
						}
					}
					return r
				}

				function u(n, r) {
					return !!n.complete && (e(n) ? r && r.call(n) : t(n, r), !0)
				}

				function c(t, n) {
					if(e(t)) return t.exifdata[n]
				}

				function d(t) {
					if(!e(t)) return {};
					var n, r = t.exifdata,
						o = {};
					for(n in r) r.hasOwnProperty(n) && (o[n] = r[n]);
					return o
				}

				function l(t) {
					if(!e(t)) return "";
					var n, o = t.exifdata,
						i = "";
					for(n in o) o.hasOwnProperty(n) && (i += "object" == r(o[n]) ? o[n] instanceof Number ? n + " : " + o[n] + " [" + o[n].numerator + "/" + o[n].denominator + "]\r\n" : n + " : [" + o[n].length + " values]\r\n" : n + " : " + o[n] + "\r\n");
					return i
				}

				function g(e) {
					return n(e)
				}
				var f = !1,
					h = {
						36864: "ExifVersion",
						40960: "FlashpixVersion",
						40961: "ColorSpace",
						40962: "PixelXDimension",
						40963: "PixelYDimension",
						37121: "ComponentsConfiguration",
						37122: "CompressedBitsPerPixel",
						37500: "MakerNote",
						37510: "UserComment",
						40964: "RelatedSoundFile",
						36867: "DateTimeOriginal",
						36868: "DateTimeDigitized",
						37520: "SubsecTime",
						37521: "SubsecTimeOriginal",
						37522: "SubsecTimeDigitized",
						33434: "ExposureTime",
						33437: "FNumber",
						34850: "ExposureProgram",
						34852: "SpectralSensitivity",
						34855: "ISOSpeedRatings",
						34856: "OECF",
						37377: "ShutterSpeedValue",
						37378: "ApertureValue",
						37379: "BrightnessValue",
						37380: "ExposureBias",
						37381: "MaxApertureValue",
						37382: "SubjectDistance",
						37383: "MeteringMode",
						37384: "LightSource",
						37385: "Flash",
						37396: "SubjectArea",
						37386: "FocalLength",
						41483: "FlashEnergy",
						41484: "SpatialFrequencyResponse",
						41486: "FocalPlaneXResolution",
						41487: "FocalPlaneYResolution",
						41488: "FocalPlaneResolutionUnit",
						41492: "SubjectLocation",
						41493: "ExposureIndex",
						41495: "SensingMethod",
						41728: "FileSource",
						41729: "SceneType",
						41730: "CFAPattern",
						41985: "CustomRendered",
						41986: "ExposureMode",
						41987: "WhiteBalance",
						41988: "DigitalZoomRation",
						41989: "FocalLengthIn35mmFilm",
						41990: "SceneCaptureType",
						41991: "GainControl",
						41992: "Contrast",
						41993: "Saturation",
						41994: "Sharpness",
						41995: "DeviceSettingDescription",
						41996: "SubjectDistanceRange",
						40965: "InteroperabilityIFDPointer",
						42016: "ImageUniqueID"
					},
					p = {
						256: "ImageWidth",
						257: "ImageHeight",
						34665: "ExifIFDPointer",
						34853: "GPSInfoIFDPointer",
						40965: "InteroperabilityIFDPointer",
						258: "BitsPerSample",
						259: "Compression",
						262: "PhotometricInterpretation",
						274: "Orientation",
						277: "SamplesPerPixel",
						284: "PlanarConfiguration",
						530: "YCbCrSubSampling",
						531: "YCbCrPositioning",
						282: "XResolution",
						283: "YResolution",
						296: "ResolutionUnit",
						273: "StripOffsets",
						278: "RowsPerStrip",
						279: "StripByteCounts",
						513: "JPEGInterchangeFormat",
						514: "JPEGInterchangeFormatLength",
						301: "TransferFunction",
						318: "WhitePoint",
						319: "PrimaryChromaticities",
						529: "YCbCrCoefficients",
						532: "ReferenceBlackWhite",
						306: "DateTime",
						270: "ImageDescription",
						271: "Make",
						272: "Model",
						305: "Software",
						315: "Artist",
						33432: "Copyright"
					},
					m = {
						0: "GPSVersionID",
						1: "GPSLatitudeRef",
						2: "GPSLatitude",
						3: "GPSLongitudeRef",
						4: "GPSLongitude",
						5: "GPSAltitudeRef",
						6: "GPSAltitude",
						7: "GPSTimeStamp",
						8: "GPSSatellites",
						9: "GPSStatus",
						10: "GPSMeasureMode",
						11: "GPSDOP",
						12: "GPSSpeedRef",
						13: "GPSSpeed",
						14: "GPSTrackRef",
						15: "GPSTrack",
						16: "GPSImgDirectionRef",
						17: "GPSImgDirection",
						18: "GPSMapDatum",
						19: "GPSDestLatitudeRef",
						20: "GPSDestLatitude",
						21: "GPSDestLongitudeRef",
						22: "GPSDestLongitude",
						23: "GPSDestBearingRef",
						24: "GPSDestBearing",
						25: "GPSDestDistanceRef",
						26: "GPSDestDistance",
						27: "GPSProcessingMethod",
						28: "GPSAreaInformation",
						29: "GPSDateStamp",
						30: "GPSDifferential"
					},
					S = {
						ExposureProgram: {
							0: "Not defined",
							1: "Manual",
							2: "Normal program",
							3: "Aperture priority",
							4: "Shutter priority",
							5: "Creative program",
							6: "Action program",
							7: "Portrait mode",
							8: "Landscape mode"
						},
						MeteringMode: {
							0: "Unknown",
							1: "Average",
							2: "CenterWeightedAverage",
							3: "Spot",
							4: "MultiSpot",
							5: "Pattern",
							6: "Partial",
							255: "Other"
						},
						LightSource: {
							0: "Unknown",
							1: "Daylight",
							2: "Fluorescent",
							3: "Tungsten (incandescent light)",
							4: "Flash",
							9: "Fine weather",
							10: "Cloudy weather",
							11: "Shade",
							12: "Daylight fluorescent (D 5700 - 7100K)",
							13: "Day white fluorescent (N 4600 - 5400K)",
							14: "Cool white fluorescent (W 3900 - 4500K)",
							15: "White fluorescent (WW 3200 - 3700K)",
							17: "Standard light A",
							18: "Standard light B",
							19: "Standard light C",
							20: "D55",
							21: "D65",
							22: "D75",
							23: "D50",
							24: "ISO studio tungsten",
							255: "Other"
						},
						Flash: {
							0: "Flash did not fire",
							1: "Flash fired",
							5: "Strobe return light not detected",
							7: "Strobe return light detected",
							9: "Flash fired, compulsory flash mode",
							13: "Flash fired, compulsory flash mode, return light not detected",
							15: "Flash fired, compulsory flash mode, return light detected",
							16: "Flash did not fire, compulsory flash mode",
							24: "Flash did not fire, auto mode",
							25: "Flash fired, auto mode",
							29: "Flash fired, auto mode, return light not detected",
							31: "Flash fired, auto mode, return light detected",
							32: "No flash function",
							65: "Flash fired, red-eye reduction mode",
							69: "Flash fired, red-eye reduction mode, return light not detected",
							71: "Flash fired, red-eye reduction mode, return light detected",
							73: "Flash fired, compulsory flash mode, red-eye reduction mode",
							77: "Flash fired, compulsory flash mode, red-eye reduction mode, return light not detected",
							79: "Flash fired, compulsory flash mode, red-eye reduction mode, return light detected",
							89: "Flash fired, auto mode, red-eye reduction mode",
							93: "Flash fired, auto mode, return light not detected, red-eye reduction mode",
							95: "Flash fired, auto mode, return light detected, red-eye reduction mode"
						},
						SensingMethod: {
							1: "Not defined",
							2: "One-chip color area sensor",
							3: "Two-chip color area sensor",
							4: "Three-chip color area sensor",
							5: "Color sequential area sensor",
							7: "Trilinear sensor",
							8: "Color sequential linear sensor"
						},
						SceneCaptureType: {
							0: "Standard",
							1: "Landscape",
							2: "Portrait",
							3: "Night scene"
						},
						SceneType: {
							1: "Directly photographed"
						},
						CustomRendered: {
							0: "Normal process",
							1: "Custom process"
						},
						WhiteBalance: {
							0: "Auto white balance",
							1: "Manual white balance"
						},
						GainControl: {
							0: "None",
							1: "Low gain up",
							2: "High gain up",
							3: "Low gain down",
							4: "High gain down"
						},
						Contrast: {
							0: "Normal",
							1: "Soft",
							2: "Hard"
						},
						Saturation: {
							0: "Normal",
							1: "Low saturation",
							2: "High saturation"
						},
						Sharpness: {
							0: "Normal",
							1: "Soft",
							2: "Hard"
						},
						SubjectDistanceRange: {
							0: "Unknown",
							1: "Macro",
							2: "Close view",
							3: "Distant view"
						},
						FileSource: {
							3: "DSC"
						},
						Components: {
							0: "",
							1: "Y",
							2: "Cb",
							3: "Cr",
							4: "R",
							5: "G",
							6: "B"
						}
					};
				return {
					readFromBinaryFile: g,
					pretty: l,
					getTag: c,
					getAllTags: d,
					getData: u,
					Tags: h,
					TiffTags: p,
					GPSTags: m,
					StringValues: S
				}
			}()
		}(window), t.default = EXIF
	}])
});