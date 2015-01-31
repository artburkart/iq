class UrlSpaceEncoder:
    def __init__(self):
        pass

    @staticmethod
    def url_space_encoder(string, true_length):
        """URL-encodes the spaces in a str

        This code operates under the assumption that we're given
        exactly enough extra space needed to push characters around
        the array

        Keyword arguments:
        string -- str to URL encode
        true_length -- length of str before space padding on end
        """
        if not isinstance(string, str):
            raise AttributeError(
                "Given input, {}, must be valid str".format(string))
        if true_length < 0:
            raise AttributeError(
                "Given input, {}, must have length >= 0".format(true_length))

        str_list = list(string)

        if len(str_list) == 0:
            return string

        placeholder = len(str_list) - 1
        for i in range(true_length)[::-1]:
            if placeholder < 0:
                break
            elif str_list[i] == ' ':
                # NOTE(arthur): Wrote this with three lines for clarity:
                # str_list[placeholder - 2: placeholder + 1] = ['%', '2', '0']
                str_list[placeholder] = '0'
                str_list[placeholder - 1] = '2'
                str_list[placeholder - 2] = '%'
                placeholder -= 3
            else:
                str_list[placeholder] = str_list[i]
                placeholder -= 1

        return "".join(str_list)
