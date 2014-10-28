# coding=utf8

from Chapter1.Problem5.StringCompressor import StringCompressor as SC
from parameterizedtestcase import ParameterizedTestCase


class StringCompressor_Test(ParameterizedTestCase):
    test_list = [
        ("", ""),
        ("ab", "ab"),
        ("abc", "abc"),
        ("aaa", "a3"),
        ("hello", "hello"),
        ("hellllllo", "h1e1l6o1"),
        ("hheelloo", "hheelloo"),
        ("hheeelloo", "h2e3l2o2")
    ]

    @ParameterizedTestCase.parameterize(("string", "expected"), test_list)
    def test_compress(self, string, expected):
        self.assertEqual(SC.compress(string), expected)

    def test_compress_with_none_string_raises_attribute_error(self):
        self.assertRaises(AttributeError, SC.compress, None)
