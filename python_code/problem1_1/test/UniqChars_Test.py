# coding=utf8

import unittest
from problem1_1.src.UniqChars import UniqChars


class UniqChars_Test(unittest.TestCase):

    def test_invalid_method_raises_exception(self):
        self.assertRaises(AttributeError, UniqChars.uniqChars, "ab", 0)

    def test_none_method_raises_exception(self):
        self.assertRaises(AttributeError, UniqChars.uniqChars, "ab", None)

if __name__ == '__main__':
    unittest.main()
