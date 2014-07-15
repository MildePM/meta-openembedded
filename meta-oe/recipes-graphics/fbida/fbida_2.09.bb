HOMEPAGE = "http://linux.bytesex.org/fbida/"
DESCRIPTION = "frame buffer image and doc viewer tools"
AUTHOR = "Gerd Hoffmann"
SECTION = "utils"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=8ca43cbc842c2336e835926c2166c28b"

DEPENDS = "virtual/libiconv libpng jpeg fontconfig freetype libexif curl giflib tiff"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI = "git://git.kraxel.org/fbida"
SRC_URI += "file://no-usr-local.diff"
SRCREV = "cb0ce5fa5f42bfaea4f8f326bcd8914dd14e782d"
S = "${WORKDIR}/git"

EXTRA_OEMAKE = "STRIP="

do_compile() {
    sed -i -e 's: cpp: ${TARGET_PREFIX}cpp -I{STAGING_INCDIR}:g' GNUmakefile
    oe_runmake
}

do_install() {
    oe_runmake 'DESTDIR=${D}' install
}

RDEPENDS_${PN} = "ttf-dejavu-sans-mono"

